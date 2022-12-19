package com.jojo.NumberRecognitionAPI.Webrest.endpoints;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jojo.NumberRecognitionAPI.Main;
import com.jojo.NumberRecognitionAPI.NeuralNetwork.StatUtil;
import com.jojo.NumberRecognitionAPI.lib.MNISTImageSave;
import com.jojo.NumberRecognitionAPI.libary.ImageHelper;
import com.jojo.NumberRecognitionAPI.libary.JsonHelper;
import com.jojo.NumberRecognitionAPI.libary.Secure;
import com.jojo.NumberRecognitionAPI.libary.Server;
import com.jojo.NumberRecognitionAPI.libary.Status;
import com.jojo.NumberRecognitionAPI.libary.StatusJson;

@Service
public class DefaultRestController implements IRestController {
    
    // Domain get code = ((""+request.getRequestURL()).split("/")[2].split(":")[0])

    public DefaultRestController() {
    	
    }

	@Override
	public ResponseEntity<String> status(HttpServletRequest request) {
        if(Secure.checkDomain(request)) {
            Server.println("[HttpClient] Status Check - Intern");
            StatusJson sj = new StatusJson(Main.KI_Status.toString(),Main.IMG_Status.toString());
        	return ResponseEntity.ok(JsonHelper.ClassToJson(sj));
        } else {
            Server.println("[HttpClient] Status Check - Extern");
            return ResponseEntity.ok("HEALTHY - EXTERN");
        }
	}

	@Override
	public ResponseEntity<String> askai(HttpServletRequest request, String image) {
        if(Secure.checkDomain(request) && Main.KI_Status != Status.OFFLINE) {
        	ArrayList<Float> ImageData;
			try {
				ImageData = ImageHelper.getImageDatafromDataURL(image);
			} catch (IOException e) {
				e.printStackTrace();
				return ResponseEntity.ok("ERROR");
			}
        	int KINumber = Main.neuralnetwork.recognitionNumber(StatUtil.ArrayListtoFloatArray(ImageData));
        	return ResponseEntity.ok(KINumber +"");
        } else {
        	return ResponseEntity.ok("WRONG DOMAIN");
        }
	}

	@Override
	public ResponseEntity<String> getrandomimg(HttpServletRequest request) {
        if(Secure.checkDomain(request) && Main.IMG_Status != Status.OFFLINE) {
        	int randomNum = ThreadLocalRandom.current().nextInt(1, 10000 + 1);
        	MNISTImageSave mis = JsonHelper.JsonToClass(Main.fileHelper.readFromDisk("data/" + randomNum + ".json"), MNISTImageSave.class);
        	System.out.println(mis.getNUMBER());
        	return ResponseEntity.ok(mis.getIMAGEDATA());
        } else {
        	return ResponseEntity.ok("WRONG DOMAIN");
        }
	}
    	
}
