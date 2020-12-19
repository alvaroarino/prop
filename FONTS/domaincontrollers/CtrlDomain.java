package domaincontrollers;

import dades.CtrlDades;

public class CtrlDomain {
    private static CtrlDomain singletonObject;

    public static CtrlDomain getInstance() {
        if (singletonObject == null)
            singletonObject = new CtrlDomain() {
            };
        return singletonObject;
    }

    private CtrlDomain() {};

    public void initData() {
        CtrlDades dades = CtrlDades.getInstance();
        dades.initData();
    }
}
