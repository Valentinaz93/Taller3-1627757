package com.clientes;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.clases.Empresas;
import com.clases.Producto;
import com.clases.Clientes;
import com.clases.Personas;

public class Main {
	
	static String opcion;
	static List<Producto> productos = new ArrayList<>();
    static List<Empresas> empresas = new ArrayList<>();
    static List<Personas> personas = new ArrayList<>();
    static List<Clientes> clientes = new ArrayList<>();
    static Scanner in = new Scanner(System.in); // se saca a Global por los nuevos métodos
    
    public static void main(String[] args) {
        String menu =
                        "         * 1 Agregar cliente\n" +
                        "         * 2 Editar cliente\n" +
                        "         * 3 Eliminar cliente\n" +
                        "         * 4 Agregar productos\n" +
                        "         * 5 Consultar clientes con documento y tipo de documento \n" +
                        "         * 0 salir de la aplicacion";
        
        
        

        //Uso clico do while() para iniciar menu
        //@Deprecated(since = "1.2", forRemoval = true)
        Integer opMenu = new Integer(0);
        /**
         * Segun el concepto de polimorfismo un objeto puede tener multiples formas
         * con la estructura de clase que se entrega por favor implementar el concepto de poliformismo
         */


        do {

            System.out.println(menu);
            opMenu = in.nextInt();
            switch (opMenu.toString()) {
                case "1":
                	opcion = in.nextLine();
                    addCliente();
                    break;
                case "2":
                	opcion = in.nextLine();
                    editCliente();
                    break;
                case "3":
                	opcion = in.nextLine();
                    deleteCliente();
                    break;
                case "4":
                	opcion = in.nextLine();
                    addProd();
                    break;
                case "5":
                	opcion = in.nextLine();
                    resultado();
                    break;
                case "0":
                    System.out.println("Muchas gracias por usar nuestra app, hasta luego");
                    break;
                default:
                    System.out.println("El valor ingresado no es una opcion de menu");
                    break;
            }
        } while (!opMenu.toString().equals("0"));
        in.close();

    }
    
    public static void addCliente() {

        Clientes cliente = new Clientes();
        Clientes cliente1;

        System.out.println("Ingrese tipo de documento: ");
        String tipoDocumento = in.nextLine();
        System.out.println("Ingrese documento");
        String documento = in.nextLine();
        cliente1 = new Clientes(tipoDocumento, documento);
        System.out.println("Ingrese nombre del cliente: ");
        cliente.setNombre(in.nextLine());
        System.out.println("Ingrese telefono del cliente: ");
        cliente.setTelefono(in.nextLine());
        System.out.println("Ingrese direccion del cliente: ");
        cliente.setDireccion(in.nextLine());
        System.out.println("Ingrese id del producto: ");
        String idProducto = in.next();

        for (Producto producto: productos) 
        {
            if(producto.getIdProducto().equals(idProducto)) 
            {
                cliente.setProductos(productos);
                break;
            }
        }

        empresas.add(cliente1);
        clientes.add(cliente);
    }

    public static void editCliente() 
    {
        System.out.println("Ingrese nombre del cliente a editar: ");
        String nombreCliente = in.nextLine();
        boolean FindClient = false;
        Iterator<Clientes> iterator = clientes.iterator();
        Clientes client;

        while (iterator.hasNext()) {  // Devuelve verdadero si este escáner tiene otro token en su entrada. Este método puede bloquearse mientras espera la entrada para escanear. El escáner no avanza más allá de ninguna entrada.

            client = iterator.next();
            if (client.getNombre().equals(nombreCliente)) 
            {
            	FindClient= true;
                String message = client.toString();
                System.out.println("Ingresa Los datos a editar\n" + message + "\n");

                System.out.println("Ingrese nombre del cliente: ");
                client.setNombre(in.nextLine());
                System.out.println("Ingrese telefono del cliente: ");
                client.setTelefono(in.nextLine());
                System.out.println("Ingrese direccion del cliente: ");
                client.setDireccion(in.nextLine());
                System.out.println("Ingrese id del producto: ");
                String idProducto = in.next();

                for (Producto producto: productos) 
                {
                    if(producto.getIdProducto().equals(idProducto)) 
                    {
                        client.setProductos(productos);
                        break;
                    }
                }
                message = client.toString();
                System.out.println(message);
            }
        }
        if (FindClient == false) { // false si el producto con las descripciones no existen 
            System.out.println("No se encontró registro");
        }
    }

  public static void deleteCliente() 
  {
        System.out.println("Ingrese nombre del cliente que se va a eliminar: ");
        String nombreCliente = in.nextLine();
        boolean FindClient = false;
        Iterator<Clientes> iterator = clientes.iterator();
        Clientes cliente;
        
        while (iterator.hasNext() && FindClient == false) { cliente = iterator.next();

            if (cliente.getNombre().equals(nombreCliente)) {
                String message = cliente.toString();
                System.out.println("\nSe eliminará el cliente: \n" + message + "\n");

                clientes.remove(cliente);
                FindClient = true;
            }
        }
        if (FindClient == false) {
            System.out.println("Cliente no encontrado");
        }
    }

    public static void addProd() 
    {

        Producto producto = new Producto();

        System.out.println("Ingrese nombre del producto: ");
        producto.setNombre(in.nextLine());
        System.out.println("Ingrese caracteristicas del producto: ");
        producto.setCarateristicas(in.nextLine());
        System.out.println("Ingrese id del producto: ");
        producto.setIdProducto(in.nextLine());
        System.out.println("Ingrese condiciones del producto: ");
        producto.setCondiciones(in.nextLine());

        productos.add(producto);
    }

    public static void resultado() {
        System.out.println("Ingrese el Tipo de Documento del cliente a validar: ");
        String findTipDocumento = in.next();
        System.out.println("Ingrese el Numero de Documento del cliente a validar:: ");
        String findNumDocumento = in.next();
        int indice = 9999;
        int i = 0;

        for (i = 0; i < clientes.size(); i++) 
        {
            String clienteTipoDocumento = empresas.get(i).getTipDoc();
            String clienteNumDocumento  = empresas.get(i).getDocumento();

            if (clienteTipoDocumento.equals(findTipDocumento))
            {
                if (clienteNumDocumento.equals(findNumDocumento))
                {
                	indice = i;
                }
            }
        }

        if (indice  != 9999)
        {
            System.out.println("Cliente " + indice);
            System.out.println("Nombre Cliente: " + clientes.get(indice).getNombre());
            System.out.println("Dirrecion Cliente: " + clientes.get(indice).getDireccion());
            System.out.println("Telefono Cliente: " + clientes.get(indice).getTelefono());

        } else 
        {
            System.out.println("Cliente no encontrado");
        }
    }
    
}
