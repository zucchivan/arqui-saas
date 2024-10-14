package zucchivan.dev.views.dashboard;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import jakarta.annotation.security.PermitAll;
import zucchivan.dev.views.dashboard.tabs.BalanceTab;
import zucchivan.dev.views.dashboard.tabs.GeneralTab;
import zucchivan.dev.views.dashboard.tabs.NotesTab;

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
        var layoutRow = new HorizontalLayout();
        var layoutColumn2 = new VerticalLayout();
        var textField = new TextField();
        var textItems = new ListBox<SampleItem>();
        var tabSheet = new TabSheet();

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

        textField.setValueChangeMode(ValueChangeMode.EAGER);
        textField.addValueChangeListener(event -> {
            String filter = event.getValue().toLowerCase();
            List<SampleItem> filteredItems = sampleItems.stream()
                    .filter(item -> item.label().toLowerCase().contains(filter))
                    .collect(Collectors.toList());
            textItems.setItems(filteredItems);
        });
    }

    record SampleItem(String value, String label, Boolean disabled) {}

    private void setMultiSelectListBoxSampleData(ListBox<SampleItem> listBox) {
        sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", null));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        listBox.setItems(sampleItems);
        listBox.setItemLabelGenerator(SampleItem::label);
        listBox.setItemEnabledProvider(item -> item != null && !Boolean.TRUE.equals(item.disabled()));
    }

    private void setTabSheetSampleData(TabSheet tabSheet) {
        tabSheet.add("Geral", new GeneralTab());
        tabSheet.add("Balanço", new BalanceTab());
        tabSheet.add("Notas", new NotesTab());
    }
}
