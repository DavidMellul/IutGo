package Ui;


import java.awt.BorderLayout;

import javax.swing.JPanel;

import Controller.MapController;
import fr.unice.iut.info.methodo.maps.JMapViewer;
import fr.unice.iut.info.methodo.maps.Layer;
import fr.unice.iut.info.methodo.maps.MemoryTileCache;
import fr.unice.iut.info.methodo.maps.checkBoxTree.CheckBoxTree;
import fr.unice.iut.info.methodo.maps.events.JMVCommandEvent;
import fr.unice.iut.info.methodo.maps.interfaces.JMapViewerEventListener;
import fr.unice.iut.info.methodo.maps.interfaces.MapMarker;
import fr.unice.iut.info.methodo.maps.interfaces.MapObject;

public class MapInterfaceTree extends JPanel implements JMapViewerEventListener {

	private static final long serialVersionUID = -5223589587768440744L;

	private JMapViewer map;
	private CheckBoxTree tree;

	public MapInterfaceTree(String name) {
		super();
		initialize();
	}

	private void initialize(){
		setLayout(new BorderLayout(0, 0));

		tree = new CheckBoxTree("World");
		
		map = new JMapViewer(new MemoryTileCache());
		map.setVisible(true);
		map.addJMVListener(this);
		MapController.init(map);
		add(map, BorderLayout.CENTER);
		setVisible(true);
	}

	public Layer addLayer(String name) {
		Layer layer = new Layer(name);
		layer.setVisible(false);
		tree.addLayer(layer);
		return layer;
	}

	public JMapViewer getViewer() {
		return map;
	}
	
	public void drawToLayer(Layer layer, MapMarker m){
		if(layer != null){
			m.setLayer(layer);
			layer.add(m);
			if(layer.isVisible()){
				map.addMapMarker(m);
			}
		}
	}
	
	public void redrawLayer(Layer... layers){
		map.removeAll();
		for(Layer l : layers){
			if(l.isVisible()){
				showLayer(l);
			}
		}
	}
	
	public void showLayer(Layer layer){
		layer.setVisible(true);
		for(MapObject m : layer.getElements()){
			if(m instanceof MapMarker){
				map.addMapMarker((MapMarker) m);
			}
		}
	}

	@Override
	public void processCommand(JMVCommandEvent command) {
		if (command.getCommand().equals(JMVCommandEvent.COMMAND.ZOOM)
				|| command.getCommand().equals(JMVCommandEvent.COMMAND.MOVE)) {
		}
	}
}
