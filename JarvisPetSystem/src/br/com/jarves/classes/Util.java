package br.com.jarves.classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

public class Util {

    public String formataCep(String cep){
        if(cep.length()>=9){
            String pri = cep.substring(0,5);
            String seg = cep.substring(6,9);
            return pri+seg;
        }
        else return null;
    }
    public String reformataCep(String cep){
        String pri = cep.substring(0,5);
        String seg = cep.substring(5,8);
        return pri + "-"+seg;
    }
    public String formataCpf(String cpf){
        String pri = cpf.substring(0,3);
        String seg = cpf.substring(4,7);
        String ter = cpf.substring(8,11);
        String qua = cpf.substring(12,14);
        
        return pri+seg+ter+qua;
    }
    public String reformataCpf(String cpf){
        String pri = cpf.substring(0,3);
        String seg = cpf.substring(3,6);
        String ter = cpf.substring(6,9);
        String qua = cpf.substring(9,11);
        
        return pri+"."+seg+"."+ter+"-"+qua;
    
    }
    public Date data(){
        DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return date;
    }
    public boolean isCPF(String CPF) { 
    // considera-se erro CPF's formados por uma sequencia de numeros iguais
    if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11)) return(false); 
    char dig10, dig11; 
    int sm, i, r, num, peso;
    // "try" - protege o codigo para eventuais erros de conversao de tipo (int) 
    try { 
        // Calculo do 1o. Digito Verificador
        sm = 0; 
        peso = 10;
        for (i=0; i<9; i++) {
            // converte o i-esimo caractere do CPF em um numero: 
            // por exemplo, transforma o caractere '0' no inteiro 0
            // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }
        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig10 = '0';
        else
            dig10 = (char)(r + 48);    // converte no respectivo caractere numerico
        // Calculo do 2o. Digito Verificador
        sm = 0;
        peso = 11;
        for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        } 
        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11)) 
            dig11 = '0';
        else dig11 = (char)(r + 48);
        // Verifica se os digitos calculados conferem com os digitos informados.
        if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
            return(true);
        else 
            return(false);
    }catch (InputMismatchException erro) { 
        return(false);
    }
  }
}


