/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projdiario;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author migue
 */

public class Diario {
    
    
    
    private Date data;
    private String texto;

    public Diario() {
    }

    @Override
    public String toString() {
        return "Diario{" + "data=" + data + ", texto=" + texto + '}';
    }
    
    
    
    
    
    
    
    public Diario(Date data, String texto){
        this.data=data;
        this.texto=texto;
        
    }

   

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

  

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Diario other = (Diario) obj;
        if (!Objects.equals(this.texto, other.texto)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }
    
    

   
    
    
    
    
}

