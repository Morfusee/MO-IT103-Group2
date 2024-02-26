package UtilityClasses;

import javax.swing.JComponent;
import javax.swing.JToolTip;
import javax.swing.Popup;
import javax.swing.PopupFactory;

public class CustomTooltip {
	private static boolean tooltipVisible = false;
	private static Popup popup;

	public static void showCustomTooltip(JComponent component, String text) {
		hideCustomTooltip(); // Hide any existing tooltip

		JToolTip toolTip = new JToolTip();
		toolTip.setTipText(text);

		PopupFactory popupFactory = PopupFactory.getSharedInstance();
		popup = popupFactory.getPopup(component, toolTip, component.getLocationOnScreen().x,
				component.getLocationOnScreen().y + toolTip.getPreferredSize().height);
		popup.show();

		tooltipVisible = true;
	}

	public static void hideCustomTooltip() {
		if (tooltipVisible) {
			popup.hide();
			tooltipVisible = false;
		}
	}
}
