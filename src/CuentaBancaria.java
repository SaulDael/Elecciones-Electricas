import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class CuentaBancaria {
    private String titular;
    private double saldo;
    private List<String> historial;

    public CuentaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
        this.historial = new ArrayList<>();
        registrarTransaccion("Su saldo es de: $" +saldo);
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto){
        saldo += monto;
        registrarTransaccion("Deposito: $" + monto);
        System.out.println("Se ha realizado un depósito de $" + monto + ". El saldo actual es de $" + saldo);
    }

    public void retirar(double monto){
        if (saldo >= monto){
            saldo -= monto;
            registrarTransaccion("Retiro: $" + monto);
            System.out.println("Se ha realizado un retiro de $" + monto + ". El saldo actual es de $" + saldo);
        }else {
            System.out.println("No se puede realizar un retiro, su daldo es de $" +saldo);
        }
    }

    public List<String> ObtenerHistorial(){
        return historial;
    }

    private void registrarTransaccion(String transaccion){
        historial.add(transaccion);
    }

    public void depositarSeguro(double monto){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(Double.toString(monto).getBytes());

            String hashBase64 = Base64.getEncoder().encodeToString(hash);

            saldo += monto;
            registrarTransaccion("Deposito Seguro $ " + monto + "(HASH realizado: " + hashBase64 + ")");
            System.out.println("Saldo de depósito seguro: " + saldo);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error al encriptar");
            e.printStackTrace();

        } ;
    }

    @Override
    public String toString() {
        return "Cuenta Bancaria: " +
                "Titular: " + titular +
                " Saldo :" + saldo;
    }
}
