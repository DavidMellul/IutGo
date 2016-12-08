package Ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import Controller.MapController;
import fr.unice.iut.info.methodo.maps.JMapViewer;
import fr.unice.iut.info.methodo.maps.MemoryTileCache;
import fr.unice.iut.info.methodo.maps.events.JMVCommandEvent;
import fr.unice.iut.info.methodo.maps.interfaces.JMapViewerEventListener;

public class MapInterfaceTree extends JPanel implements JMapViewerEventListener {
	
	private static final long serialVersionUID = -5223589587768440744L;

    public static JMapViewer map;
    
	public MapInterfaceTree(String name) {
		super();
		initialize();
	}
	
	private void initialize(){
		
		map = new JMapViewer(new MemoryTileCache());
		new MapController(map);
		
		map.setVisible(true);
		setVisible(true);
		setLayout(new BorderLayout(0, 0));
		
		add(map, BorderLayout.CENTER);
	}
	
    @Override
    public void processCommand(JMVCommandEvent command) {
        if (command.getCommand().equals(JMVCommandEvent.COMMAND.ZOOM) ||
                command.getCommand().equals(JMVCommandEvent.COMMAND.MOVE)) {
        }
    }

}
