public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuentaBancaria = new CuentaBancaria("Saul Dael", 2500);
        cuentaBancaria.depositar(10000);
        cuentaBancaria.retirar(1000);
        cuentaBancaria.depositarSeguro(50000);
        cuentaBancaria.depositar(100);
        cuentaBancaria.retirar(20000);
        cuentaBancaria.depositar(3000);
        cuentaBancaria.retirar(1000);
        System.out.println(cuentaBancaria.ObtenerHistorial());

    }
}
