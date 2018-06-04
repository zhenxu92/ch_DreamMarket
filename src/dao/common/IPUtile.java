package dao.common;

import java.net.InetAddress;

public class IPUtile {
	public static String CreatSessionID(String realIP) {
		InetAddress ia=null;
		String localip = null;
		String Ipid = null;
        try {
            ia=InetAddress.getLocalHost();
       	 	localip=ia.getHostAddress();
             if("127.0.0.1".equals(localip)){
            	 System.out.println("当前网络未连接");
            	 return "0.1";
             }else{
            	 Ipid = localip.substring(8);
            	 Ipid = Ipid.replace(".","");
             }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String sessionID = realIP+":"+Ipid;
		return sessionID;
	}
	public static void main(String[] args) {
		System.out.println(CreatSessionID("666"));
	}
}
