package com.example.demo.services;

import com.example.demo.payload.ok;
import java.util.List;
public interface ok2 {
ok addusers(ok up);
ok updateusers(ok up,int id);
void deleteusers(int id);
List<ok>getallusers();
ok getbyid(int id);

}