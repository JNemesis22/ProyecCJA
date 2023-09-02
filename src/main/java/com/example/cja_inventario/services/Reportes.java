package com.example.cja_inventario.services;

import com.example.cja_inventario.interfaceServices.I_productoServices;
import com.example.cja_inventario.models.Producto;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.export.SimpleExporterInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Reportes {

    @Autowired
     private I_productoServices servP;
    public byte[] exportToPdf(List<Producto> list) throws JRException, FileNotFoundException {
        return JasperExportManager.exportReportToPdf(getReport(list));
    }

    /*    public byte[] exportToXls(List<Producto> list) throws JRException, FileNotFoundException {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        SimpleOutputStreamExporterOutput output = new SimpleOutputStreamExporterOutput(byteArray);
        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setExporterInput(new SimpleExporterInput(getReport(list)));
        exporter.setExporterOutput(output);
        exporter.exportReport();
        output.close();
        return byteArray.toByteArray();
    }*/

    private JasperPrint getReport(List<Producto> list) throws FileNotFoundException, JRException {
        Map<String, Object> params = new HashMap<String, Object>();


        List<Producto> lista= servP.listar();
       params.put("petsData", new JRBeanCollectionDataSource(lista));

        JasperPrint report = JasperFillManager.fillReport(JasperCompileManager.compileReport(
                ResourceUtils.getFile("classpath:reporte.jrxml")
                        .getAbsolutePath()), params, new JREmptyDataSource());
        return report;
    }
}
