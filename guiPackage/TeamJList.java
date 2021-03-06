package guiPackage;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import defaultPackage.Team;

public class TeamJList implements ComponentListener, ListSelectionListener {
	// we can write our own "ListModel" that extends AbstractListModel
	private DefaultListModel<Team> listModel;
	private JList<Team> list; //Pretty sure you want this to be of type team right?? It was giving a warning because you didn't specify 
	private JScrollPane listScrollPane;
	private MenuPanel mp;
	private JTextField searchBar;
	
	// the constraints here are actually for the top left of the item
	public TeamJList (MenuPanel mp, JTextField searchBar) {
		this.mp = mp;
		this.searchBar = searchBar;
		listModel = new DefaultListModel<Team>();
		// i could write my own list model that adheres to ListModel interface
		// using .insertElementAt() we can keep elements in alphabetical order?
		
		//Create the list 
		list = new JList<>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);
		
		// fired whenever the selection changes
		// for us: should change which team is being displayed
		//list.addListSelectionListener(this);
		
		//list.setVisibleRowCount(1);
		// and puts it in a scroll pane
		listScrollPane = new JScrollPane(list);
		listScrollPane.setBounds(20, 175, 210, 350);
		mp.add(listScrollPane);
		mp.addComponentListener(this);	// so that resizing the screen resizes the list
		
	}
	
	public void populateList(List<HashMap<String, String>> teams, StatusDisplay sd) {
		// all mens teams
		HashMap<String, String> mensTeams = teams.get(0);
		for(String team: mensTeams.keySet()){
			listModel.addElement(Team.createNew(team, sd));
		}
		// , mensTeams.get(team)
		
		
		
		// all womens teams
		HashMap<String, String> womensTeams = teams.get(1);
		for(String team: womensTeams.keySet()){
			listModel.addElement(Team.createNew(team, sd));
		}
	}

	public void add(Team t) {
		listModel.addElement(t);
	}
	
	@Override
	public void componentHidden(ComponentEvent arg0) {}

	@Override
	public void componentMoved(ComponentEvent arg0) {}

	// called every time the screen is resized
	@Override
	public void componentResized(ComponentEvent arg0) {
		listScrollPane.setBounds(20, 175, 210, mp.getHeight() - 200);
	}

	@Override
	public void componentShown(ComponentEvent arg0) {}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false && list.getSelectedIndex() != -1) {
			// puts team's URL in the search bar if selected
			searchBar.setText(listModel.get(list.getSelectedIndex()).getName());
		}
	}
}
