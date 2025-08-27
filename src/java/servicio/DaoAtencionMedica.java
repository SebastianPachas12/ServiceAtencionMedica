
package servicio;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DaoAtencionMedica {
    
    public static String getCodigoGenerado(){
        return Acceso.getNum("select * from AtencionMedica");
    }
    
    public static String getFec(){
        Date dat = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dat);
    }
    
    public static String getHor(){
        Date dat = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        return sdf.format(dat);
    }
    
    public static String grabarAtencion(AtencionMedica am){
        String sql = "insert into AtencionMedica values ('"+am.getCod()+"','"+am.getDniHis()+"','"+am.getNomHis()+"','"+am.getDirHis()+"','"+am.getEnfHis()+"','"+am.getAleHis()+"','"+am.getOpeHis()+"','"+am.getFecCit()+"','"+am.getHorIniCit()+"','"+am.getDig()+"','"+am.getRec()+"','"+am.getAnl()+"', '"+am.getFec()+"','"+am.getHor()+"')";
        String msg = Acceso.ejecutar(sql);
        if(msg==null){
            msg="Atencion Medica grabada con exito";
        }
        return msg;
    }
    
    public static String[] datosAtencionDhis(String cod) {
        String sql = "select * from AtencionMedica where cod = '" + cod + "'";
        Object[] f = Acceso.buscar(sql);
        if (f != null) {
            String[] atm = {f[0].toString(), f[1].toString(), f[2].toString(), f[3].toString(), f[4].toString(), f[5].toString(), f[6].toString(), f[7].toString(),
                f[8].toString(), f[9].toString(), f[10].toString(), f[11].toString(), f[12].toString(), f[13].toString()};
            return atm;
        }
        return null;
    }
    
}
