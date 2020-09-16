package com.vending.utility;

import com.google.common.base.Preconditions;
import com.sun.tools.javac.util.Pair;
import com.vending.classes.EnumGenericFunctions;
import com.vending.enums.COMMODITIES;
import io.vavr.control.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.regex.Pattern;

public class VendingUtils extends EnumGenericFunctions {
    private static final Logger lOGGER= LoggerFactory.getLogger(VendingUtils.class);
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public VendingUtils(Class enumType) {
        super(enumType);
    }

    public static void validateArguments(String[] args) {
        lOGGER.info(CONSTANTS.ARGUMENTS_LENGTH + args.length+ "(Commodity: "+args[0]+",Price: "+ args[1]+"/-)");
        Preconditions.checkState(!(args.length==0),CONSTANTS.NO_ARGUMENTS);
        Preconditions.checkArgument((args.length  == 2) ,CONSTANTS.VALID_ARGUMENTS);
        Preconditions.checkState(!pattern.matcher(args[0]).matches(),CONSTANTS.FIRST_ARGUMENTS);
        Preconditions.checkState(!areArgValid(args).isLeft(),CONSTANTS.NO_NULL_ARGUMENTS);

    }

    private static Either<String, String> areArgValid(String[] args) {
        if(args[0].equalsIgnoreCase("null") || args[1].equalsIgnoreCase("null"))
            return Either.left(CONSTANTS.INVALID_PATTERN);
        else
            return Either.right(CONSTANTS.SUCCESS);
    }


    public static void calculateBill(String[] args) {
        Preconditions.checkArgument(!(Integer.parseInt(args[1])  > 50)  ,CONSTANTS.DENOMINATION_LIMIT);
        Pair<String,Integer> enumValues = fromCodeToEnum(args[0], COMMODITIES.class);
        if(enumValues!=null) evaluate(enumValues,args);
        else lOGGER.info(CONSTANTS.NO_COMMODITY_AVAILABLE+args[0]);


    }

    private static void evaluate(Pair<String, Integer> enumValues,String[] args) {
        lOGGER.info(CONSTANTS.PRICE_FOR+enumValues.fst+CONSTANTS.IS+enumValues.snd+CONSTANTS.RS);
        lOGGER.info(CONSTANTS.PRICE_PAID+args[1]+CONSTANTS.RS);
        if(checkPaidAndMRP(Integer.parseInt(args[1]),enumValues.snd)) lOGGER.info(CONSTANTS.INVALID_PRICE);
        else { lOGGER.info(CONSTANTS.AVAILABLE_BALANCE+(Integer.parseInt(args[1])-enumValues.snd)+CONSTANTS.RS);
               lOGGER.info(CONSTANTS.PLEASE_COLLECT+enumValues.fst+CONSTANTS.FROM_OUTLET);
        }

    }
    public static boolean checkPaidAndMRP(Integer paid, Integer MRP){
        return (paid < MRP) ? true : false;
    }
}
