/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author Acer
 */
public class UnorientedGraph implements IGraph {
    
    private final ArrayList<TreeSet<Integer>> _nodes;
    
    public UnorientedGraph(int size){
        
        _nodes = new ArrayList<>(2 * size);
        
        for(int i = 0; i < size; i++){
            _nodes.add(new TreeSet<>());
        }
    }

    @Override
    public boolean addEdge(int from, int to) {
        
        if((from < 0) || (from >= _nodes.size())
                || (to < 0) || (to >= _nodes.size())){
            
            return false;
        }
        
        return (_nodes.get(from).add(to) && _nodes.get(to).add(from));
    }

    @Override
    public boolean deleteEdge(int from, int to) {
        
        if((from < 0) || (from >= _nodes.size())
                || (to < 0) || (to >= _nodes.size())){
            
            return false;
        }
        
        return (_nodes.get(from).remove(to) && _nodes.get(to).remove(from));
    }

    @Override
    public int addNode() {
        
        _nodes.add(new TreeSet<>());
        
        return _nodes.size() - 1;
    }

    @Override
    public boolean deleteNode(int nodeNumber) {
        
        if((nodeNumber >= _nodes.size()) || (nodeNumber < 0)){
            
            return false;
        }
        
        _nodes.remove(nodeNumber);
        
        for(var i : _nodes){
            i.remove(nodeNumber);
        }
        
        return true;
    }

    @Override
    public Integer[] getNeighbours(int node) throws IllegalArgumentException {

        if((node >= _nodes.size()) || (node < 0)){
            
            throw new IllegalArgumentException("not valid parameter 'node'");
        }
        
        return _nodes.get(node).toArray(Integer[]::new);
    }

    @Override
    public int size() {
        
        return _nodes.size();
    }
    
}
