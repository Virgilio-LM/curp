package obtencurp;

import javax.swing.JOptionPane;

/**
 *
 * @author Virgilio LM <virgili0@yahoo.com>
 */
public class curp {

    public curp() {
        
    }
    
    Integer dia = 0,  anio = 0, longitud = 0;
    String genero = "", estado = "", mes = "";
    String nombre = "", apellidoM = "", apellidoP = "", EF="", curpF = "";
    Boolean masDe1 = false;
            
    public void obtenFecha(String a, String b, String c){
        
        dia = Integer.parseInt(a);
        mes = b;
        anio = Integer.parseInt(c);
    }
    
    public void obtenGenero(String radio){
        genero = radio;
    }
    
    public void obtenEstado(String eleccionEstado){
        estado = eleccionEstado.toUpperCase();
    }
    
    //{\ public void mostrarDatos(){
     //JOptionPane.showMessageDialog(null, "La fecha es "+dia+"/"+mes+"/"+anio);
     //JOptionPane.showMessageDialog(null, "El género seleccionado es "+genero);
     //JOptionPane.showMessageDialog(null, "La entidad federativa seleccionada es "+estado);
     //JOptionPane.showMessageDialog(null, "El nombre completo es "+nombre+" "+apellidoP+" "+apellidoM);
    //}
    
    public void obtenNombrecompleto(String a, String b, String c){
        nombre = a.toUpperCase();    //captura y convierte a mayuscla
        apellidoP = b.toUpperCase();
        apellidoM = c.toUpperCase();
    }
    
    public void generaCURP(){
        
        char c1 = apellidoP.charAt(0); //1r car del 1r apellido
        char c2 = 0;
        for (int i = 0; i < apellidoP.length(); i++) {
            char aux = apellidoP.charAt(i);
            if(aux == 'A' || aux == 'E' || aux == 'I' || aux == 'O' || aux == 'U' ){
            c2 = aux;
            break;
        }
    }
        char c3 = apellidoM.charAt(0);
        char c4 = nombre.charAt(0);
        char c5 = (String.valueOf(anio)).charAt(2); //convierte a String -anio- y
        char c6 = (String.valueOf(anio)).charAt(3); // selecciona el 2o y 3r char
        
        char c7 = (String.valueOf(mes)).charAt(0); //convierte a String -mes- y
        char c8 = (String.valueOf(mes)).charAt(1); // selecciona el 0o y 1r char
        
        char c9 = ('0'+String.valueOf(dia)).charAt(0); //convierte a String -dia- y
        char c10 = ('0'+String.valueOf(dia)).charAt(1); // selecciona el 0o y 1r char
        
        char c10a = genero.charAt(0);
        char c11 = estado.charAt(0); //1r car del -estado-
        
        
        //char c13 ='*';
        longitud = estado.length();   // verifiK que -estado- tiene mas de una palabra
          for (int i = 0; i < (longitud-1); i++){
            char aux2 = estado.charAt(i);
            if (aux2 == ' ' && i != (longitud-1)){
                //System.out.println(c13+"");
                masDe1 = true;
            break;
            }else
                {
                    masDe1 = false;
                   
                }
            
        }
          //System.out.println(masDe1); // si el nombre del -estado- esta compuesto
                                        // por mas de una palabra regresa true
        char c12 =0;
        if (masDe1){
            switch(estado){
            case "BAJA CALIFORNIA ":
                //System.out.println(estado);
                c12 = 'C';
                break;
            case "BAJA CALIFORNIA SUR ":
                c12 = 'S';
                break;
            case "CIUDAD DE MÉXICO ":
                c12 = 'M';            
                break;
            case "COAHUILA DE ZARAGOZA ":
                c12 = 'L';
                break;
            case "ESTADO DE MÉXICO ":
                c11 = 'M';
                c12 = 'C';            
                break; 
            case "MICHOACAN DE OCAMPO ":
                c12 = 'N';            
                break;
            case "NUEVO LEÓN ":
                c12 = 'L';            
                break;
            case "QUERÉTARO DE ARTEAGA ":
                c12 = 'T';            
                break;
            case "QUINTANA ROO ":
                c12 = 'R';            
                break;                
            case "SAN LUIS POTOSÍ ":
                c12 = 'P';            
                break;                 
        }
        }else
        {
        //longitud = estado.length();
        // c12 =0;
        for (int i = 0; i < longitud; i++) {
            char aux2 = estado.charAt(longitud-i-2);
            if (aux2 == 'A'|| aux2 == 'E' || aux2 == 'I' || aux2 == 'O' || aux2 == 'U' ){
            c12 = 0;
            //
            }else
                {
                    c12 = aux2;
                    break;
                }
        }
        }
        
        ////////////// encontramos el 1r consonante del apellido paterno
        char c14 = 0;
                for (int i = 1; i < apellidoP.length(); i++) {
            char aux3 = apellidoP.charAt(i);
            if (aux3 != 'A'&& aux3 != 'E' && aux3 != 'I' && aux3 != 'O' && aux3 != 'U' ){
            c14 = aux3;
            break;
            }
        }

        ////////////// encontramos el 1r consonante del apellido materno
        char c15 = 0;
                for (int i = 1; i < apellidoM.length(); i++) {
            char aux4 = apellidoM.charAt(i);
            if (aux4 != 'A'&& aux4 != 'E' && aux4 != 'I' && aux4 != 'O' && aux4 != 'U' ){
            c15 = aux4;
            break;
            }
        }                
          
                
        ////////////// encontramos el 1r consonante del nombre
        char c16 = 0;
                for (int i = 1; i < nombre.length(); i++) {
            char aux4 = nombre.charAt(i);
            if (aux4 != 'A'&& aux4 != 'E' && aux4 != 'I' && aux4 != 'O' && aux4 != 'U' ){
            c16 = aux4;
            break;
            }
        }
           
                char c17 = '0';
                char c18 = '0';
        /////// finalamente imprimimos la CURP completa
        
  curpF = String.valueOf(c1+""+c2+""+c3+""+c4+""+c5+""+c6+""+c7+""+c8+""+c9+""+c10+""+c10a+""+c11+""+c12+""+c14+""+c15+""+c16+""+c17+""+c18);
    JOptionPane.showMessageDialog(null,curpF);
        
    }
    public void resta(double n1, double n2){
      
        resultado = n1 - n2;
        }
}
