package com.example.cja_inventario.interfaceServices;

import com.example.cja_inventario.models.Producto;
import com.example.cja_inventario.services.Reportes;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.util.List;

public interface I_reportesService  {

    byte[] exportPdf() throws JRException, FileNotFoundException;


}
