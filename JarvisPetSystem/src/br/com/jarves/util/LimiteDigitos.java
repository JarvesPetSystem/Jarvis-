
package br.com.jarves.util;

import javax.swing.text.*;


public class LimiteDigitos extends PlainDocument{
    int tam = 0;
    
    public LimiteDigitos(int t){
        this.tam = t;
    }
    
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        int tamanho = (this.getLength() + str.length());
        if(tamanho<=tam){
            super.insertString(offs, str, a);             
        }else{
            super.insertString(offs, str.replaceAll("[aA0-zZ9]", ""), a);
        }
        
    }
    
   
}
