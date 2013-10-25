package com.company;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {
    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        Label label = new Label("This will fade out once you click the button");
        
        Button button = new Button("Hide Label");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                JavaScript.getCurrent().execute("$('.v-label').animate({opacity: 0.4}, 1500);");        
            }
        });
        layout.addComponent(label);
        layout.addComponent(button);
    }
}
