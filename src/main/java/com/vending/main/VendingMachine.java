package com.vending.main;
import com.vending.classes.EnumGenericFunctions;
import com.vending.utility.CONSTANTS;
import com.vending.utility.VendingUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VendingMachine extends EnumGenericFunctions {

    private static final Logger lOGGER= LoggerFactory.getLogger(VendingMachine.class);

    public VendingMachine(Class enumType) {
        super(enumType);
    }

    public static void main(String[] args)  {
        VendingUtils.validateArguments(args);
        VendingUtils.calculateBill(args);
        lOGGER.info(CONSTANTS.THANK_YOU_NOTE);
    }
}
