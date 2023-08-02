package com.example.demo.services.imple;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptionhandling.resourcesnotFoundException;
import com.example.demo.models.mouli;
import com.example.demo.payload.ok;
import com.example.demo.repository.repository_repo;
import com.example.demo.services.ok2;

@Service
public class impile implements ok2 {
	@Autowired
	repository_repo repo;
	@Autowired
	ModelMapper modelmapper;

	@Override
	public ok addusers(ok up) {
		mouli s=this.dto_mouli(up);
		mouli savemouli=this.repo.save(s);
		return this.mouli_dto(savemouli);
		
	}

	@Override
	public ok updateusers(ok up, int id) {
		// TODO Auto-generated method stub
		mouli all = this.repo.findById(id).orElseThrow(()-> new resourcesnotFoundException("mouli","id",id));
		all.setName(up.getName());
		all.setEmail(up.getEmail());
		all.setPassword(up.getPassword());
		mouli all1=this.repo.save(all);
		ok ep=this.mouli_dto(all1);
		return ep;
	}

	@Override
	public void deleteusers(int id) {
		// TODO Auto-generated method stub
		 mouli all=this.repo.findById(id).orElseThrow(()-> new resourcesnotFoundException("mouli", "id", id));
		 this.repo.delete(all);

	}

	@Override
	public List<ok> getallusers() {
		// TODO Auto-generated method stub
		List<mouli>m = (List<mouli>)this.repo.findAll();
		List<ok>o=m.stream().map(mou->this.mouli_dto(mou)).collect(Collectors.toList());
		return o;
	}

	@Override
	public ok getbyid(int id) {
		// TODO Auto-generated method stub
		mouli a1=this.repo.findById(id).orElseThrow(()-> new resourcesnotFoundException("mouli", "id", id));
		return this.mouli_dto(a1);
		
	}
	public mouli dto_mouli(ok emp) {
		mouli m=this.modelmapper.map(emp, mouli.class);
				return m;
	}
	public ok mouli_dto(mouli em) {
		ok o=this.modelmapper.map(em, ok.class);
				return o;
	}

}
