package zucchivan.dev.views.dashboard;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import jakarta.annotation.security.PermitAll;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@PageTitle("Dashboard")
@Route("")
@Menu(order = 0, icon = "line-awesome/svg/pencil-ruler-solid.svg")
@PermitAll
public class DashboardView extends Composite<VerticalLayout> {

    private List<SampleItem>  sampleItems;

    public DashboardView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        TextField textField = new TextField();
        ListBox textItems = new ListBox();
        TabSheet tabSheet = new TabSheet();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutColumn2.setWidth("200px");
        layoutColumn2.getStyle().set("flex-grow", "1");
        textField.setLabel("Text field");
        textField.setWidth("min-content");
        textItems.setWidth("min-content");
        setMultiSelectListBoxSampleData(textItems);
        tabSheet.setWidth("100%");
        setTabSheetSampleData(tabSheet);
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(textField);
        layoutColumn2.add(textItems);
        layoutRow.add(tabSheet);

        textField.addValueChangeListener(event -> {
            String filter = event.getValue().toLowerCase();
            List<SampleItem> filteredItems = sampleItems.stream()
                    .filter(item -> item.label().toLowerCase().contains(filter))
                    .collect(Collectors.toList());
            textItems.setItems(filteredItems);
        });
    }

    record SampleItem(String value, String label, Boolean disabled) {}

    private void setMultiSelectListBoxSampleData(ListBox listBox) {
        sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        listBox.setItems(sampleItems);
        listBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
        listBox.setItemEnabledProvider(item -> !Boolean.TRUE.equals(((SampleItem) item).disabled()));
    }

    private void setTabSheetSampleData(TabSheet tabSheet) {
        tabSheet.add("Dashboard", new Div(new Text("This is the Dashboard tab content")));
        tabSheet.add("Payment", new Div(new Text("This is the Payment tab content")));
        tabSheet.add("Shipping", new Div(new Text("This is the Shipping tab content")));
    }
}
