package com.bezkoder.spring.jwt.mongodb.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bezkoder.spring.jwt.mongodb.models.Corruption;
import com.bezkoder.spring.jwt.mongodb.models.FileProof;
import com.bezkoder.spring.jwt.mongodb.models.FileR;
import com.bezkoder.spring.jwt.mongodb.models.Image;
import com.bezkoder.spring.jwt.mongodb.models.ImageProof;
import com.bezkoder.spring.jwt.mongodb.models.Location;
import com.bezkoder.spring.jwt.mongodb.models.LocationProof;
import com.bezkoder.spring.jwt.mongodb.models.Video;
import com.bezkoder.spring.jwt.mongodb.models.VideoProof;
import com.bezkoder.spring.jwt.mongodb.models.Voice;
import com.bezkoder.spring.jwt.mongodb.models.VoiceProof;
import com.bezkoder.spring.jwt.mongodb.repository.UserRepository;
import com.twilio.converter.DateConverter;

import io.jsonwebtoken.io.IOException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public com.bezkoder.spring.jwt.mongodb.models.User findUserByUsername(String username) {
		Optional<com.bezkoder.spring.jwt.mongodb.models.User> user=userRepository.findByUsername(username);
		if(!user.isEmpty()) {
			return user.get();
		}
		return null;
	}
	
	public com.bezkoder.spring.jwt.mongodb.models.User updateUser(String id, com.bezkoder.spring.jwt.mongodb.models.User user){
		Optional<com.bezkoder.spring.jwt.mongodb.models.User> findUser=userRepository.findById(id);
		if(!findUser.isEmpty()) {
			userRepository.save(user);
		}
		return user;
	}
	public List<com.bezkoder.spring.jwt.mongodb.models.User> findAll(){
		return userRepository.findAll();
	}
	
	public Optional<com.bezkoder.spring.jwt.mongodb.models.User> retrieve_user(String id){
		return userRepository.findById(id);
	}
	public void make_image_profile(String user_id, String name, MultipartFile file) throws IOException, java.io.IOException { 
        Image image = new Image(name); 
        image.setImage(
          new Binary(BsonBinarySubType.BINARY, file.getBytes())
          ); 
        Optional<com.bezkoder.spring.jwt.mongodb.models.User> user=userRepository.findById(user_id);
        
        user.get().setProfile_image(image);
        user.get().setHas_profile_image(true);
        userRepository.save(user.get());
        
        //photo = photoRepo.insert(photo); return photo.getId(); 
    }

	public void make_corruption(String user_id, String content,String truth, String has_proofs, 
			String has_images_proofs, List<MultipartFile> images_proofs, String images_proofs_description,  
			String has_videos_proofs, List<MultipartFile> videos_proofs, String videos_proofs_description, 
			String has_voices_proofs, List<MultipartFile> voices_proofs, String voices_proofs_description, 
			String has_documents_proofs, List<MultipartFile> documents_proofs, String documents_proofs_description,
			String has_locations_proofs, String locations_proofs, String locations_proofs_description
			)
					throws IOException, java.io.IOException{
		// TODO Auto-generated method stub
		Optional<com.bezkoder.spring.jwt.mongodb.models.User> user=userRepository.findById(user_id);
		String id=String.valueOf(new Date());
		Corruption corruption=new Corruption(id, new Date(), content, Integer.parseInt(truth));
		if(has_proofs.equals(new String("YES"))) {
			if(has_images_proofs.equals(new String("YES"))) {
				
				String[] descriptions=images_proofs_description.split("=");
				
				for(int cmp=0; cmp<images_proofs.size(); cmp++) {
					Image one_image=new Image(images_proofs.get(cmp).getName());
					one_image.setImage(new Binary(BsonBinarySubType.BINARY, images_proofs.get(cmp).getBytes()));
					ImageProof images_proofs_object=new ImageProof(id, one_image);
					images_proofs_object.setDescription(descriptions[cmp]);
					corruption.addOneProof(images_proofs_object);
				}
			}
			
			if(has_videos_proofs.equals(new String("YES"))) {
				
				String[] descriptions=videos_proofs_description.split("=");
				
				for(int cmp=0; cmp<videos_proofs.size(); cmp++) {
					Video one_video=new Video(videos_proofs.get(cmp).getName());
					one_video.setVideo(new Binary(BsonBinarySubType.BINARY, videos_proofs.get(cmp).getBytes()));
					VideoProof video_proof_object=new VideoProof(id, one_video);
					video_proof_object.setDescription(descriptions[cmp]);
					corruption.addOneProof(video_proof_object);
					
				}
			}
			
			if(has_voices_proofs.equals(new String("YES"))) {
				
				String[] descriptions=voices_proofs_description.split("=");
				
				for(int cmp=0; cmp<voices_proofs.size(); cmp++) {
					Voice one_voice=new Voice(voices_proofs.get(cmp).getName());
					one_voice.setVoice(new Binary(BsonBinarySubType.BINARY, voices_proofs.get(cmp).getBytes()));
					VoiceProof voice_proof_object=new VoiceProof(id, one_voice);
					voice_proof_object.setDescription(descriptions[cmp]);
					corruption.addOneProof(voice_proof_object);
				}
			}
			
			if(has_documents_proofs.equals(new String("YES"))) {
				
				String[] descriptions=documents_proofs_description.split("=");
				
				for(int cmp=0; cmp<documents_proofs.size(); cmp++) {
					FileR one_document=new FileR(documents_proofs.get(cmp).getName());
					one_document.setDocument(new Binary(BsonBinarySubType.BINARY, documents_proofs.get(cmp).getBytes()));
					FileProof document_proof_object=new FileProof(id, one_document);
					document_proof_object.setDescription(descriptions[cmp]);
					corruption.addOneProof(document_proof_object);
				}
			}
			
			if(has_locations_proofs.equals(new String("YES"))) {
				
				String[] descriptions=locations_proofs_description.split("=");
				
				 String[] locations_array=locations_proofs.split("%");
				 for(int cmp=0; cmp<locations_array.length; cmp++) {
					 String[] one_location=locations_array[cmp].split("?");
					 Location one_location_object=new Location();
					 one_location_object.setPosX(one_location[0]);
					 one_location_object.setPosY(one_location[1]);
					 one_location_object.setRoute(one_location[2]);
					 one_location_object.setCity(one_location[3]);
					 one_location_object.setCountry(one_location[4]);
					 LocationProof location_proof_object=new LocationProof(id, one_location_object);
					 location_proof_object.setDescription(descriptions[cmp]);
					 corruption.addOneProof(location_proof_object);
				 
				 }
			}
			user.get().addOneCorruption(corruption);
			userRepository.save(user.get());
		}
	
		
	}
}
