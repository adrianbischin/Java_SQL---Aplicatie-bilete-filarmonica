package Logic_and_GUI;

import javax.swing.*;
import java.awt.*;

public class InfoGUI {

    private JFrame infoFrame;
    private JTabbedPane infoTabbedPane;
    private JPanel historyPanel;
    private JPanel orchestraPanel;
    private JPanel choirPanel;
    private JPanel conductorsPanel;
    private JPanel teamPanel;
    private JLabel historyLabel;
    private JLabel orchestraLabel;
    private JLabel choirLabel;
    private JLabel conductorsLabel;
    private JLabel teamLabel;
    private JTextArea historyTextArea;
    private JTable orchestraTable;
    private JTable choirTable;
    private JTable conductorsTable;
    private JTable teamTable;

    public InfoGUI(String[][] orchestraPlayers, String[][] choirPlayers, String[][] conductors, String[][] teamMembers) {

        //labels font
        Font f = new Font("Comic Sans MS", Font.BOLD, 20);

        //history text
        String history = "          Ca instituţie artistică dedicată exclusiv activităţii de concert, Filarmonica clujeană a fost înfiinţată printr-un decret oficial al Consiliului de Miniştri al României în toamna anului 1955, cu numele oficial de Filarmonica de Stat Cluj. La data înfiinţării, formaţiile muzicale au fost orchestra simfonică mare, cu un număr de 75 muzicieni, şi un ansamblu instrumental de muzică tradiţională, cu un număr de 20 muzicieni. Sub direcţia iniţială a dirijorului Wilhelm Demian, s-a realizat o selecţie a membrilor proaspetei instituţii prin concurs, comisiile fiind prezidate de către marele dirijor Antonin Ciolan, cu participarea celor mai reputaţi specialişti clujeni ai epocii. Antonin Ciolan a fost numit dirijor principal al orchestrei simfonice, dirijând primul concert al acesteia pe data de 4 decembrie 1955, într-un veritabil tur de forţă: Preludiul la Maeştrii cântăreţi din Nürnberg de Wagner, Concertul nr. 1 pentru orchestră de coarde de Sigismund Toduţă, Concertul nr. 2 pentru pian de Rahmaninov (cu Silvia Şerbescu) şi Eroica lui Beethoven. La începutul anului 1956, el a preluat şi funcţia de director al Filarmonicii.\n" +
                "\n" +
                "           Tradiţia activităţii simfonice în Cluj datează de la începutul secolului al XIX-lea, fiind întreţinută succesiv de asociaţii ca Orchestra Teatrului Maghiar (înfiinţată în 1792), Societatea de Muzică, Cercul de Muzică. În perioada interbelică a existat o adevărată emulaţie în susţinerea de evenimente simfonice de către orchestrele Operei Române (înfiinţată în 1919), a Teatrului Maghiar şi de către o orchestră susţinută de comunitatea evreiască a oraşului, numită Orchestra „Goldmark” (condusă de Wilhelm Demian). În 1947 a avut loc prima tentativă de înfiinţare a unei instituţii de concert – Filarmonica „Ardealul”, care a avut o existenţă efemeră de doar două stagiuni, însă care a creat premisele reuşitei de mai târziu.\n" +
                "\n" +
                "           Pe fondul acestor antecedente şi prin activitatea de formator a Maestrului Ciolan, sprijinită pe excelenta pregătire a tinerilor muzicieni, oferită de Academia de Muzică clujeană (pe atunci numită Conservatorul de Muzică „Gheorghe Dima”), progresul Filarmonicii a fost deosebit de rapid, impunând în scurt timp instituţia printre valorile naţionale reprezentative. Încă de la fondarea instituţiei, alături de ansamblurile muzicale au fost cooptaţi cei mai prestigioşi solişti clujeni ai momentului – flautistul Dumitru Pop şi pianistul Gheorghe Halmos, cărora li s-a adăugat ulterior violonistul Ştefan Ruha, cel care urma să-şi construiască o remarcabilă carieră internaţională, rămânând în acelaşi timp fidel Filarmonicii de-a lungul a trei decenii.\n" +
                "\n" +
                "           Deja din primii ani s-au afirmat la pupitrul orchestrei simfonice excepţionalii discipoli ai Maestrului Ciolan – dirijorii Emil Simon şi Erich Bergel. Un alt dirijor renumit al României, Cristian Mandeal, a parcurs la pupitrul orchestrei clujene una dintre cele mai fructuoase perioade ale devenirii sale artistice.\n" +
                "\n" +
                "           În 1965, Filarmonica a lansat propriul său festival anual, „Toamna Muzicală Clujeană”, manifestare de referinţă continuată cu succes şi în prezent. În 1966 a luat fiinţă Orchestra de Cameră a Filarmonicii, rod al colaborării cu reputatul dirijor Mircea Cristescu.\n" +
                "\n" +
                "           În 1972, sub directoratul compozitorului Sigismund Toduţă (care i-a succedat lui Antonin Ciolan), a luat fiinţă Corul Filarmonicii, format de maestrul Dorin Pop, urmat apoi de discipolii săi Florentin Mihăescu şi Cornel Groza.\n" +
                "\n" +
                "           Oaspeţii de marcă ai Filarmonicii – între care nume legendare ale artei interpretative şi componistice ca Stanisław Wisłocki, Kurt Masur, Kirill Kondrashin, Jean-Pierre Rampal, Witold Lutosławski, Carlo Zecchi, Yannis Xenakis, János Ferencsik, Aldo Ciccolini, Krzysztof Penderecki, Michi Inoue, Stefan Anton Reck, Sir John Pritchard, Anatole Fistoulari, George Georgescu, André Jolivet, Edvard Tchivjel, Adrian Sunshine, Horia Andreescu, Laurent Petitgirard, Maurice Handford, Leopold Hager, Valery Gergiev, Alexandr Dmitriev, Lawrence Foster, Antonello Allemandi, Sascha Goetzel, John Axelrod, Jörg Widmann, Monique Haas, Sviatoslav Richter, Ruggiero Ricci, Valentin Gheorghiu, Friedrich Gulda, Annie Fischer, Aldo Ciccolini, Dmitri Bashkirov, Dan Grigore, Lazar Berman, Radu Lupu, Jean Pierre Rampal, Silvia Marcovici, Mihaela Martin, Bruno Leonardo Gelber, Patrik Gallois, José Carreras, Angela Gheorghiu, Philippe Entremont, Roberto Alagna, Raphael Wallfisch, David Grimal, Tatiana Lisnic, Freddy Kempf, Christian Lindberg, Liviu Prunaru, Raúl Jaurena, Marcel Khalifé şi mulţi alţii, au contribuit la edificarea unui standard valoric internaţional şi în egală măsură la dobândirea unui solid renume al ansamblului în cercurile muzicale internaţionale. Turneele numeroase în străinătate, realizate cu regularitate de către orchestra simfonică, dar şi de ansamblul coral, au confirmat şi reconfirmat acest renume. O importantă producţie discografică rămâne mărturie a valorilor temeinice create de-a lungul deceniilor de către muzicienii clujeni.\n" +
                "\n" +
                "           La cârma Filarmonicii, celor doi mari ctitori le-au urmat personalităţi ale vieţii culturale clujene – scriitorul Dumitru Mircea, muzicologul Rodica Oana Pop, violonistul Radu Grecu, compozitorul Adrian Pop (sub direcţia căruia, în 1993, a fost adoptată denumirea actuală de Filarmonica de Stat „Transilvania”), violonistul George Dudea, dirijorul Emil Simon, managerul Denisa Piteiu, violonista Dorina Mangra – care, parcurgând etape mai faste sau mai dificile, au ştiut să păstreze şi să dezvolte tradiţiile şi valorile instituţiei. Astăzi, sub conducerea lui Marius Tabacu, Filarmonica „Transilvania” onorează aceste tradiţii printr-o impresionantă carte de vizită şi un neobosit potenţial artistic.\t\n";


        //history components
        historyLabel = new JLabel("Istoric:", JLabel.CENTER);
        historyLabel.setBounds(200, 10, 300, 30);
        historyLabel.setFont(f);
        historyLabel.setForeground(Color.DARK_GRAY);
        historyTextArea = new JTextArea(history);
        historyTextArea.setBackground(new Color(240,240,240));
        historyTextArea.setEditable(true);
        historyTextArea.setLineWrap(true);
        historyTextArea.setWrapStyleWord(true);
        historyTextArea.setEditable(false);
        JScrollPane historyScroll = new JScrollPane(historyTextArea);
        historyScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        historyScroll.setBounds(50, 60, 600, 360);
        // history panel
        historyPanel = new JPanel();
        historyPanel.setLayout(null);
        historyPanel.setVisible(true);
        historyPanel.setBackground(new Color(240, 240, 240));
        historyPanel.add(historyLabel);
        historyPanel.add(historyScroll);


        //orchestra components
        orchestraLabel = new JLabel("Instrumentiști:", JLabel.CENTER);
        orchestraLabel.setBounds(200, 10, 300, 30);
        orchestraLabel.setFont(f);
        orchestraLabel.setForeground(Color.DARK_GRAY);
        orchestraTable = new JTable(orchestraPlayers, new String[]{"Id", "Nume", "Prenume", "Partidă", "Șef partidă", "Concertmaestru"});
        JScrollPane orchestraScroll = new JScrollPane(orchestraTable);
        orchestraScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        orchestraScroll.setBounds(40, 60, 600, 360);
        //orchestra panel
        orchestraPanel = new JPanel();
        orchestraPanel.setLayout(null);
        orchestraPanel.setVisible(true);
        orchestraPanel.setBackground(new Color(240, 240, 240));
        orchestraPanel.add(orchestraLabel);
        orchestraPanel.add(orchestraScroll);


        //choir components
        choirLabel = new JLabel("Coriști:", JLabel.CENTER);
        choirLabel.setBounds(200, 10, 300, 30);
        choirLabel.setFont(f);
        choirLabel.setForeground(Color.DARK_GRAY);
        choirTable = new JTable(choirPlayers, new String[]{"Id", "Nume", "Prenume", "Partidă", "Șef partidă"});
        JScrollPane choirScroll = new JScrollPane(choirTable);
        choirScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        choirScroll.setBounds(40, 60, 600, 360);
        //choir panel
        choirPanel = new JPanel();
        choirPanel.setLayout(null);
        choirPanel.setVisible(true);
        choirPanel.setBackground(new Color(240, 240, 240));
        choirPanel.add(choirLabel);
        choirPanel.add(choirScroll);


        //conductors components
        conductorsLabel = new JLabel("Dirijori:", JLabel.CENTER);
        conductorsLabel.setBounds(200, 10, 300, 30);
        conductorsLabel.setFont(f);
        conductorsLabel.setForeground(Color.DARK_GRAY);
        conductorsTable = new JTable(conductors, new String[]{"Id", "Nume", "Prenume", "Informații"});
        JScrollPane conductorsScroll = new JScrollPane(conductorsTable);
        conductorsScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        conductorsScroll.setBounds(40, 60, 600, 360);
        //conductors panel
        conductorsPanel = new JPanel();
        conductorsPanel.setLayout(null);
        conductorsPanel.setVisible(true);
        conductorsPanel.setBackground(new Color(240, 240, 240));
        conductorsPanel.add(conductorsLabel);
        conductorsPanel.add(conductorsScroll);


        //team components
        teamLabel = new JLabel("Echipă:", JLabel.CENTER);
        teamLabel.setBounds(200, 10, 300, 30);
        teamLabel.setFont(f);
        teamLabel.setForeground(Color.DARK_GRAY);
        teamTable = new JTable(teamMembers, new String[]{"Id", "Nume", "Prenume", "Funcție"});
        JScrollPane teamScroll = new JScrollPane(teamTable);
        teamScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        teamScroll.setBounds(40, 60, 600, 360);
        //team panel
        teamPanel = new JPanel();
        teamPanel.setLayout(null);
        teamPanel.setVisible(true);
        teamPanel.setBackground(new Color(240, 240, 240));
        teamPanel.add(teamLabel);
        teamPanel.add(teamScroll);


        //tabbed pane
        infoTabbedPane = new JTabbedPane();
        infoTabbedPane.add("Istoric", historyPanel);
        infoTabbedPane.add("Instrumentiști", orchestraPanel);
        infoTabbedPane.add("Coriști", choirPanel);
        infoTabbedPane.add("Dirijori", conductorsPanel);
        infoTabbedPane.add("Echipă", teamPanel);


        //frame
        infoFrame = new JFrame("Filarmonica de stat Transilvania Cluj-Napoca");
        infoFrame.setBounds(300,150, 700, 500);
        infoFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        infoFrame.setResizable(false);
        infoFrame.setLayout(null);
        infoFrame.setContentPane(infoTabbedPane);
        infoFrame.setVisible(true);
    }
}