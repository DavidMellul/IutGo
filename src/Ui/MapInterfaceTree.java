package Ui;


import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import Controller.MapController;
import fr.unice.iut.info.methodo.maps.JMapViewer;
import fr.unice.iut.info.methodo.maps.Layer;
import fr.unice.iut.info.methodo.maps.MapMarkerDot;
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
	private HashMap<String, Layer> layers;

	public MapInterfaceTree(String name) {
		super();
		initialize();
	}

	private void initialize(){
		
		map = new JMapViewer(new MemoryTileCache());
		tree = new CheckBoxTree("World");
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
			}
		});
		new MapController(map);
		
		map.setVisible(true);
		map.addJMVListener(this);
		
		setVisible(true);
		setLayout(new BorderLayout(0, 0));
		
		layers = new HashMap<>();
		Layer l = addLayer("Relations");
		layers.put("Relations", l);
		MapMarkerDot eberstadt = new MapMarkerDot(l, "Eberstadt", 49.814284999, 8.642065999);
		l.add(eberstadt);
		
		add(tree, BorderLayout.EAST);
		add(map, BorderLayout.CENTER);
	}

	public Layer addLayer(String name) {
		Layer layer = new Layer(name);
		layer.setVisible(false);
		this.addLayer(layer);
		return layer;
	}

	public MapInterfaceTree addLayer(Layer layer) {
		tree.addLayer(layer);
		return this;
	}

	public MapInterfaceTree addLayer(MapObject element) {
		// element.getLayer().add(element);
		return addLayer(element.getLayer());
	}

	public Layer removeFromLayer(MapObject element) {
		element.getLayer().getElements().remove(element);
		return element.getLayer();
	}

	public static int size(List<?> list) {
		return list == null ? 0 : list.size();
	}

	public JMapViewer getViewer() {
		return map;
	}

	public void addMarker(String layer, MapMarker marker) {
		if (layers.containsKey(layer)) {
			marker.setLayer(layers.get(layer));
			map.addMapMarker(marker);
		}
	}

	public void showLayer(String layer) {
		if (layers.containsKey(layer)) {
			layers.get(layer).setVisible(true);
		}
	}

	public void hideAllLayers() {
		for (Layer l : layers.values()) {
			l.setVisible(false);
		}
	}

	@Override
	public void processCommand(JMVCommandEvent command) {
		if (command.getCommand().equals(JMVCommandEvent.COMMAND.ZOOM)
				|| command.getCommand().equals(JMVCommandEvent.COMMAND.MOVE)) {
		}
	}
}
