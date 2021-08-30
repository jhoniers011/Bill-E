package com.example.bill_e.controller;

import android.app.Activity;
import android.content.Context;

import com.example.bill_e.adapter.CantidadProductoAdapter;
import com.example.bill_e.adapter.ClienteAdapter;
import com.example.bill_e.adapter.ProductoAdapter;
import com.example.bill_e.model.LocalStorage;
import com.example.bill_e.model.dao.ClienteRoomDao;
import com.example.bill_e.model.dao.ProductoRoomDao;
import com.example.bill_e.model.pojo.Cliente;
import com.example.bill_e.model.pojo.Producto;
import com.example.bill_e.view.CantidadProductosActivity;
import com.example.bill_e.view.EmpleadoActivity;
import com.example.bill_e.view.RealizarVentaActivity;
import com.example.bill_e.view.SeleccionarClienteActivity;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoController {

    private ClienteRoomDao clienteRoomDao;
    private ProductoRoomDao productoRoomDao;


    public void comprobarCantidades(CantidadProductosActivity activity, CantidadProductoAdapter adapter){

        ArrayList<Integer> cantidades = adapter.getCantidades();
        boolean vacio = false;

        for (int i=0; i< cantidades.size();i++){
            if (cantidades.get(i) == 0 || cantidades.get(i) == null){
                vacio = true;
                break;
            }
        }

        if (vacio){
            activity.cantidadesVacio();
        }else {
            activity.cantidadesCorrecto();
        }

        //Si es correcto llama al metodo CantidadesCorrecto().
        //activityCantidadesProcucto.cantiadesCorrecto()
    }

    public void comprobarConexion(EmpleadoActivity EmpleadoActivity){
        // Si hay conexión
        EmpleadoActivity.conexionCorrecta();

        // Si no hay conexión


    }

    public void comprobarSeleccionarProducto(RealizarVentaActivity activity, ProductoAdapter adapter){

        if (!adapter.getSelected()){
            activity.noSeleccionado();
            return;
        }
        else {
            activity.ComprobadoExito();
        }

    }

    public  void comprobarSeleccionarCliente(SeleccionarClienteActivity activity, ClienteAdapter adapter){

        if (adapter.getPosition() == -1){
                activity.clienteNoSeleccionado();
                return;
        }
        else {
            activity.correctoSiguiente();
        }

    }

    public  List<Cliente> listarClientes(Context context){

        this.clienteRoomDao = LocalStorage.getLocalStorage(context).clienteRoomDao();
        return this.clienteRoomDao.getAll();

    }

    public  List<Producto> listarProductos(Context context){

        this.productoRoomDao = LocalStorage.getLocalStorage(context).productoRoomDao();
        return this.productoRoomDao.getAll();

    }

    //Inserta a la base de datos si está vacía una lista de productos y clientes por defecto
    public void llenarProductosyClientes(Context context){
        this.clienteRoomDao = LocalStorage.getLocalStorage(context).clienteRoomDao();
        List<Cliente> listaclientes = this.clienteRoomDao.getAll();

        this.productoRoomDao = LocalStorage.getLocalStorage(context).productoRoomDao();
        List<Producto> listaproductos = this.productoRoomDao.getAll();

        if (listaclientes.size() <= 0){

            Cliente cliente1 = new Cliente();
            cliente1.setTipodocumento("C.C");
            cliente1.setDocumentoidentidad("1025897416");
            cliente1.setTelefono("4836574");
            cliente1.setEmail("alberto98@gmail.com");
            cliente1.setDireccion("Cra 38 # 26-78");
            cliente1.setPais("Colombia");
            cliente1.setDepartamento("Antioquia");
            cliente1.setMunicipio("Bello");
            cliente1.setCodigopostal("0505055");
            cliente1.setTipocliente("Persona");
            cliente1.setNombre("Alberto");
            cliente1.setApellidos("Saldarriaga botero");
            this.clienteRoomDao.insertOne(cliente1);

            Cliente cliente2 = new Cliente();
            cliente2.setTipodocumento("T.I");
            cliente2.setDocumentoidentidad("978976584");
            cliente2.setTelefono("6587498");
            cliente2.setEmail("Cristian96@gmail.com");
            cliente2.setDireccion("Cll 98 C # 54 50");
            cliente2.setPais("Colombia");
            cliente2.setDepartamento("Santander");
            cliente2.setMunicipio("cimitarra");
            cliente2.setCodigopostal("686041");
            cliente2.setTipocliente("Persona");
            cliente2.setNombre("Cristian");
            cliente2.setApellidos("Torres Cuartas");
            this.clienteRoomDao.insertOne(cliente2);

            Cliente cliente3 = new Cliente();
            cliente3.setDocumentoidentidad("1035987453");
            cliente3.setTipodocumento("C.C");
            cliente3.setTelefono("4789568");
            cliente3.setEmail("EmpresaMendez@gmail.com");
            cliente3.setDireccion("Diag 50 # 20 36");
            cliente3.setPais("Colombia");
            cliente3.setDepartamento("Cundinamarca");
            cliente3.setMunicipio("Soacha");
            cliente3.setCodigopostal("250053");
            cliente3.setTipocliente("Empresa");
            cliente3.setRazonsocial(" Mendez y C.I.A");
            cliente3.setRut("695071000");
            this.clienteRoomDao.insertOne(cliente3);


        }

        if (listaproductos.size() <= 0){
            Producto producto1 = new Producto();
            producto1.setCodigo_barras(536874);
            producto1.setNombre("Computador portatil");
            producto1.setPrecio(2000000);
            producto1.setCosto(1600000);
            producto1.setCantidad(15);
            producto1.setMarca("Dell");
            producto1.setDescripcion("8 gb Ram, Disco duro 1000 Gb, intel i5 8400f");
            producto1.setIva(19);
            this.productoRoomDao.insertOne(producto1);

            Producto producto2 = new Producto();
            producto2.setCodigo_barras(254935);
            producto2.setNombre("Comedor 4 puestos");
            producto2.setPrecio(1200000);
            producto2.setCosto(800000);
            producto2.setCantidad(8);
            producto2.setMarca("Ikea");
            producto2.setDescripcion("Comedor aglomerado MDF rectangular");
            producto2.setIva(19);
            this.productoRoomDao.insertOne(producto2);
            Producto producto3 = new Producto();
            producto3.setCodigo_barras(896524);
            producto3.setNombre("Morral Negro Grande");
            producto3.setPrecio(150000);
            producto3.setCosto(95000);
            producto3.setCantidad(25);
            producto3.setMarca("Totto");
            producto3.setDescripcion("Porta PC, porta Botellas, espaldar acolchado");
            producto3.setIva(19);
            this.productoRoomDao.insertOne(producto3);
        }

    }


}
