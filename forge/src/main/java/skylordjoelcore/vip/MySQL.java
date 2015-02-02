package skylordjoelcore.vip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import net.minecraft.entity.player.EntityPlayerMP;

public class MySQL {
	private Connection cn = null;
	private static long timecheck = 0L;
	private final VIP plugin;
	private ResultSet r;

	public MySQL(VIP plugin) {
		this.plugin = plugin;
	    timecheck = System.currentTimeMillis();
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	this.cn = DriverManager.getConnection("jdbc:mysql://" + 
	        plugin.getConfig().getString("MySQL.MySQL-Hostname", "db") + "/" + 
	        plugin.getConfig().getString("MySQL.MySQL-Database", "db"), 
	        plugin.getConfig().getString("MySQL.MySQL-User", "user"), 
	        plugin.getConfig().getString("MySQL.MySQL-Password", "pw"));
	    	checkDatabase();
	    	
	    } catch (Exception ex) {
	    	//plugin.getLogger().warning(ex.getLocalizedMessage());
			System.out.println("WARNING: " + ex.getLocalizedMessage());
	    	ex.printStackTrace();
		}
	}

	public void reconnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.cn = DriverManager.getConnection("jdbc:mysql://" + 
	        this.plugin.getConfig().getString("MySQL.MySQL-Hostname", "db") + "/" + 
	        this.plugin.getConfig().getString("MySQL.MySQL-Database", "db"), 
	        this.plugin.getConfig().getString("MySQL.MySQL-User", "user"), 
	        this.plugin.getConfig().getString("MySQL.MySQL-Password", "pw"));
			checkDatabase();
		} catch (Exception ex) {
			//this.plugin.getLogger().warning(ex.getLocalizedMessage());
			System.out.println("WARNING: " + ex.getLocalizedMessage());
			ex.printStackTrace();
		}
	}

	public void checkConnection() throws SQLException {
		if (timeCheck())
			reconnect();
	}

  	public static boolean timeCheck() {
  		if (System.currentTimeMillis() - 100000L > timecheck) {
  			timecheck = System.currentTimeMillis();
  			return true;
	    }
  		timecheck = System.currentTimeMillis();
	    return false;
  	}

  	public void checkDatabase() throws SQLException {
  		checkConnection();
	    Statement st = null;
	    st = this.cn.createStatement();
	    st.execute("CREATE TABLE IF NOT EXISTS `VIPUsers` (`ID` INT(10) NOT NULL AUTO_INCREMENT,`playername` CHAR(50) NOT NULL DEFAULT 'player',`priority` INT(10) NOT NULL DEFAULT '1',PRIMARY KEY (`ID`))COMMENT='Here you can add new users, so they are VIPs!'");

	    st = this.cn.createStatement();
	    st.execute("CREATE TABLE IF NOT EXISTS `VIPPermissions` (`ID` INT(10) NOT NULL AUTO_INCREMENT,`Permissionsnode` CHAR(50) NOT NULL DEFAULT 'VIP.VIP',`priority` INT(10) NOT NULL DEFAULT '1',PRIMARY KEY (`ID`))COMMENT='Here you can add permission nodes!'");
  	}

  	public ResultSet showDbTable(String table) throws SQLException {
  		checkConnection();
	    Statement st = null;
	    ResultSet rs = null;

	    st = this.cn.createStatement();
	    rs = st.executeQuery("select * from " + table);

	    return rs;
  	}

  	public ResultSet executeWHERE(String table, String statement) throws SQLException {
	    checkConnection();
	    Statement st = null;
	    ResultSet rs = null;

	    st = this.cn.createStatement();
	    rs = st.executeQuery("select * from " + table + " WHERE " + statement);

	    return rs;
  	}

  	public int getPlayer(String playername) throws SQLException {
	    this.r = executeWHERE("VIPUsers", "playername='" + playername + "'");
	    
	    if (this.r.first()) {
	    	return this.r.getInt(3);
	    }
	    return 0;
  	}

  	public int getPermission(String playername) throws SQLException {
	    this.r = showDbTable("VIPPermissions");
	    
	    EntityPlayerMP player = this.plugin.getPlayer(playername);
	    
	    while (this.r.next()) { 
	    	if (player.hasPermission("VIP." + this.r.getString(2))) {
	    		return this.r.getInt(3);
	    	}
	    }
	    return 0;
  	}
}