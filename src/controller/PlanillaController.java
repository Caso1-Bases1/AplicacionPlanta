package controller;

import core.Planilla;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.PlanillaModel;

/**
 *
 * @author Nelson
 */
public class PlanillaController {

    private PlanillaModel planillaModel;

    public PlanillaController() {
        planillaModel = new PlanillaModel();
    }

    public List<Planilla> getPlanilla(DefaultTableModel model, String fechaInicial, String fechaFinal, int peridoPago) {
        return this.planillaModel.getPlanilla(model, fechaInicial, fechaFinal, peridoPago);
    }
    
    public void aprovarPlanilla (List<Planilla> planillas, String fechaInicial){
        this.planillaModel.aprovarPlanilla(planillas, fechaInicial);
    }
}
