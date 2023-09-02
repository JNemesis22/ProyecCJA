package com.example.cja_inventario.services;


import com.example.cja_inventario.interfaceServices.I_reportesService;
import com.example.cja_inventario.repository.productoRepository;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class ReportesServices  implements I_reportesService {

    @Autowired
    private productoRepository prodRepository;

    @Autowired
    private Reportes report;

    @Override
    public byte[] exportPdf() throws JRException, FileNotFoundException {
        return report.exportToPdf(prodRepository.findAll());
    }
}
