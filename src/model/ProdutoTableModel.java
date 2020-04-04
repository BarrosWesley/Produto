/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wesley
 */
public class ProdutoTableModel extends AbstractTableModel{

    private List<Produto> dados = new ArrayList<>();
    private String[] colunas = {"Descrição","QTD","Valor"};

    @Override
    public String getColumnName(int column) {
    	
        return colunas[column]; //Identifica o nome das colunas
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return dados.get(linha).getDescricao();
            case 1:
                return dados.get(linha).getQtd();
            case 2: 
                return dados.get(linha).getValor();
        }
        
        return null;
        
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
    	switch(coluna){
        case 0:
            dados.get(linha).setDescricao((String) valor);
            break;
        case 1:
            dados.get(linha).setQtd(Integer.parseInt((String) valor));
            break;
        case 2: 
            dados.get(linha).setValor(Double.parseDouble((String) valor));
            break;
    }
    	
    	this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addRow(Produto p){
        this.dados.add(p);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    
}
	