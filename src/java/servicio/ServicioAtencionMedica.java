package servicio;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "ServicioAtencionMedica")
public class ServicioAtencionMedica {

    @WebMethod(operationName = "crearAtencionMedica")
    public Object[] crearAtencionMedica() {
        Object[]fil=new Object[3];
        fil[0]=DaoAtencionMedica.getCodigoGenerado();
        fil[1]=DaoAtencionMedica.getFec();
        fil[2]=DaoAtencionMedica.getHor();
        return fil;
    }

    @WebMethod(operationName = "grabarAtencionMedica")
    public String grabarAtencionMedica(
            @WebParam(name = "dni_cit") String dni_cit, 
            @WebParam(name = "nom_his") String nom_his, 
            @WebParam(name = "dir_his") String dir_his, 
            @WebParam(name = "enf_his") String enf_his, 
            @WebParam(name = "ale_his") String ale_his, 
            @WebParam(name = "ope_his") String ope_his, 
            @WebParam(name = "fec_cit") String fec_cit, 
            @WebParam(name = "horIni_cit") String horIni_cit, 
            @WebParam(name = "dig") String dig, 
            @WebParam(name = "rec") String rec, 
            @WebParam(name = "anl") String anl) {
        
        Object[] datosGenerados = crearAtencionMedica();
        String cod = (String) datosGenerados[0];
        String fec = (String) datosGenerados[1];
        String hor = (String) datosGenerados[2];
        
        AtencionMedica am = new AtencionMedica(cod,dni_cit,nom_his,dir_his,enf_his,ale_his,ope_his,fec_cit,horIni_cit,dig,rec,anl,fec,hor);
        
        return DaoAtencionMedica.grabarAtencion(am);
    }
    @WebMethod(operationName = "datosAtencionDhis")
    public String[] datosAtencionDhis(@WebParam(name = "cod") String cod) {
        return DaoAtencionMedica.datosAtencionDhis(cod);
    }
}
