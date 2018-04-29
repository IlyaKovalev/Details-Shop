package ExecuteProgram;

import DAO.CustomerDAO;
import DAO.DetailDAO;
import DAO.Shopping_listDAO;
import Entity.Detail;
import Entity.Shopping_list;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import org.springframework.context.ApplicationContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ControllerWorkWindow implements Cloneable{
    @FXML private Button Buy;
    @FXML private AnchorPane Pane;
    @FXML private Label title;
    @FXML private Label description;
    @FXML private ListView List_View;
    @FXML private Label Price;
    @FXML private Label totalPrice;

    public static ObservableList<Detail> observableList = FXCollections.observableArrayList();
    private static int price;

    Detail detail;
    ApplicationContext context = ExecuteProgram.context;

    public void initialize(){

        final Spinner<Integer> spinner = new Spinner<>();
        spinner.setEditable(true);
        final int initialvalue=0;
        int maxCount = 0;

        spinner.setLayoutX(700);
        spinner.setLayoutY(326);
        Pane.getChildren().add(spinner);

        DetailDAO detailDAO = (DetailDAO) context.getBean("DetailDAOimpl");
        CustomerDAO customerDAO =(CustomerDAO)context.getBean("CustomerDAOimpl");
        Shopping_listDAO shopping_listDAO = (Shopping_listDAO) context.getBean("Shopping_list");

        List<Detail> details = detailDAO.getAll();
        SpinnerValueFactory<Integer> valueFactory =
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0,maxCount,initialvalue);
        spinner.setValueFactory(valueFactory);
        observableList.addAll(details);
        List_View.setItems(observableList);
        List_View.setCellFactory(new Callback<ListView<Detail>, ListCell<Detail>>() {
        @Override
        public ListCell<Detail> call(ListView<Detail> listView) {

            ListCell<Detail> cell = new ListCell<Detail>(){

                @Override
                protected void updateItem(Detail item,boolean empty){
                    super.updateItem(item,empty);
                    if (item!=null){
                        setText(item.getName()+"       "+item.getCount()+" штук         "+item.getPrice()+" рублей");
                    }
                }
            };
            return cell;
        }
    });

        List_View.getSelectionModel().selectedItemProperty().addListener(listener->{
            detail = (Detail) List_View.getSelectionModel().getSelectedItems().get(0);
            if (detail!=null) {
                title.setText(detail.getName());
                description.setText(detail.getDescription());
                price = detail.getPrice();
                Price.setText(String.valueOf(price * spinner.getValue()));
                ((SpinnerValueFactory.IntegerSpinnerValueFactory) valueFactory).setMax(detail.getCount());
            }
        });

        spinner.valueProperty().addListener((newValue)->{
            Price.setText(String.valueOf(price*spinner.getValue()));
        });

        Buy.setOnAction(event->{
            if (detail!=null) {
                Shopping_list shopping_list = (Shopping_list) context.getBean("list");
                shopping_list.setCount(spinner.getValue());
                if (shopping_list.getCount()!=0){
                    shopping_list.setCustomer(customerDAO.getCustomer(ControllerMain.hash));
                    shopping_list.setDetailID(((Detail) List_View.getSelectionModel().getSelectedItems().get(0)));
                    shopping_listDAO.insert(shopping_list);
                    detail.setCount(detail.getCount() - spinner.getValue());
                    detailDAO.update(detail);

                    for (int i = 0; i < details.size(); i++) {
                        if (detail.getId() == details.get(i).getId()) {
                            details.get(i).setCount(detail.getCount());
                        }
                    }
                }
                observableList.clear();
                observableList.addAll(details);
                List_View.setItems(observableList);
                totalPrice.setText("Итого : " + Price.getText());
                valueFactory.setValue(0);
            }
        });
    }
}
