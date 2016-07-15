package Galaxy.DataBase.Golovach_JDBC_Main.Connections;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ConnectionFactoryFactory {
	public static enum FactoryType {RAW,C3P0,PROXOOL,DBCP,VAHA_CONNECTION};
	
	private static FactoryType currentType = FactoryType.RAW;
	private static List<ConnectionFactory> allFactories = new LinkedList<ConnectionFactory>();
	
	public static synchronized void setType(FactoryType type){
		currentType = type;
	}

	public static ConnectionFactory newConnectionFactory() {
		ConnectionFactory result = null;
		try{
			switch(currentType){
			case RAW:
				result = new ConnectionFacoryJDBC();
				break;
			
		    case C3P0:
			result = new ConnectionFacoryC3P0();
			break;
		    
	        case PROXOOL:
		    result = new ConnectionFactoryProxool();
		    break;
	       
            case DBCP:
	        result = new ConnectionFactoryDbcp();
	        break;
           
            case VAHA_CONNECTION:
    	        result = new ConnectionFacoryJDBC();
    	        break;
    	        
    	    default:
    	    	throw new RuntimeException("Never");
    	    	
		    }}catch(SQLException e){
		    try {
				throw new Exception(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		    }
		return result;}
			
		
		
	}
	
