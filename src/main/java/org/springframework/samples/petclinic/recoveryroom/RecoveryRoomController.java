package org.springframework.samples.petclinic.recoveryroom;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
    
    private static final String VIEW_RR_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
    private static final String VIEW_WELCOME = "welcome";

    private final RecoveryRoomService rrs;

	@Autowired
	public RecoveryRoomController(RecoveryRoomService rrooms) {
		this.rrs = rrooms;
	}

    @InitBinder("recoveryRoom")
    public void initRecoveryRoomBinder(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping(value = "/create")
    public String initCreationForm(Map<String, Object> model){
        RecoveryRoom rr = new RecoveryRoom();
        model.put("recoveryRoom", rr);
        return VIEW_RR_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping(value = "/create")
    public String processCreationForm(@Valid RecoveryRoom rr, BindingResult result){
        if(result.hasErrors()){
            return VIEW_RR_CREATE_OR_UPDATE_FORM;
        }else{
            this.rrs.save(rr);
            return VIEW_WELCOME;
        }
    }
}
