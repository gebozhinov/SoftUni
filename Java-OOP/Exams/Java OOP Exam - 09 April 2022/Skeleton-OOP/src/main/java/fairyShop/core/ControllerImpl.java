package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;
import fairyShop.repositories.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static fairyShop.common.ConstantMessages.*;
import static fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Helper> helpers;
    private Repository<Present> presents;

    private Shop shop;

    public ControllerImpl() {
        this.helpers = new HelperRepository();
        this.presents = new PresentRepository();
        this.shop = new ShopImpl();
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;
        switch (type) {
            case "Happy":
                helper = new Happy(helperName);
                break;
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            default:
                throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }
        helpers.add(helper);
        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = helpers.getModels().stream().filter(helper1 -> helper1.getName().equals(helperName))
                .findFirst().orElse(null);
        if (helper == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }

        Instrument instrument = new InstrumentImpl(power);
        helpers.findByName(helperName).addInstrument(instrument);
        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        presents.add(present);
        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
//        List<Helper> helperList = helpers.getModels().stream()
//                .filter(helper -> helper.getEnergy() > 50)
//                .collect(Collectors.toList());
//        if (helperList.isEmpty()) {
//            throw new IllegalArgumentException(NO_HELPER_READY);
//        }
//
//        Shop shop = new ShopImpl();
//        Present present = presents.findByName(presentName);
//        for (Helper helper : helperList) {
//            shop.craft(present, helper);
//        }
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(String.format(PRESENT_DONE, presentName, present.isDone() ? "done" : "not done"));
//
//        int brokenInstruments = 0;
//        List<Collection<Instrument>> collect = helperList.stream().map(Helper::getInstruments).collect(Collectors.toList());
//        for (Collection<Instrument> instruments : collect) {
//            for (Instrument instrument : instruments) {
//                if (instrument.isBroken()) {
//                    brokenInstruments++;
//                }
//            }
//        }
//        sb.append(String.format(COUNT_BROKEN_INSTRUMENTS, brokenInstruments));
//        return sb.toString();
        List<Helper> collect = helpers.getModels().stream().filter(helper -> helper.getEnergy() > 50)
                .collect(Collectors.toList());
        if (collect.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        }
        int brokenInstruments = 0;
        Present present = presents.findByName(presentName);
        for (Helper helper : collect) {
            shop.craft(present, helper);
            brokenInstruments += (int) helper.getInstruments().stream().filter(Instrument::isBroken).count();
            if (present.isDone()){
                break;
            }
        }
        if (present.isDone()) {
            return String.format(ConstantMessages.PRESENT_DONE, presentName, "done") +
                    String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstruments);
        }
        return String.format(ConstantMessages.PRESENT_DONE, presentName, "not done") +
                String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstruments);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        long craftedPresents = presents.getModels().stream().filter(Present::isDone).count();

        sb.append(String.format("%d presents are done!", craftedPresents)).append(System.lineSeparator());
        sb.append("Helpers info:").append(System.lineSeparator());
        for (Helper helper : helpers.getModels()) {
            sb.append(String.format("Name: %s", helper.getName())).append(System.lineSeparator());
            sb.append(String.format("Energy: %d", helper.getEnergy())).append(System.lineSeparator());
            long countInstruments = helper.getInstruments().stream().filter(instrument -> !instrument.isBroken()).count();
            sb.append(String.format("Instruments: %d not broken left", countInstruments)).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
