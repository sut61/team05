import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {FormControl, Validators} from '@angular/forms';
import { HttpClient} from '@angular/common/http';
import { CommentService, Comment } from '../shared/comment.service';

export interface Tool {
  name: string;
  name1: string;
  name2: string;
}

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  comment: Comment = new Comment();
  levels: Array<any>;
  comments: Array<any>;

  provinces: Array<any>;
  genders: Array<any>;

  province: '';
  gender: '';

constructor(
  private service: CommentService , private httpClient: HttpClient) { }

  ngOnInit() {
    this.service.getLevel().subscribe(data => {
      this.levels = data;
      console.log(this.levels);
    });

    this.service.getComment().subscribe(data => {
      this.comments = data;
      console.log(this.comments);
    });

    this.service.getProvince().subscribe(data => {
      this.provinces = data;
      console.log(this.provinces);
    });

    this.service.getGender().subscribe(data => {
      this.genders = data;
      console.log(this.genders);
    });
  }

  save(){
    if(this.comment.name == '' || this.comment.name == null){
      alert('กรุณากรอกชื่อ')
    }else if(this.comment.phone == '' || this.comment.phone == null){
      alert('กรุณากรอกเบอร์โทรศัพท์')
    }else if(this.gender == '' || this.gender == null){
      alert('กรุณาเลือกเพศ')
    }else if(this.province == '' || this.province == null){
      alert('กรุณาเลือกจังหวัด')
    }else if(this.comment.level1 == '' || this.comment.level1 == null){
      alert('กรุณาเลือกระดับความพึงพอใจ')
    }else if(this.comment.level2 == '' || this.comment.level2 == null){
      alert('กรุณาเลือกระดับความพึงพอใจ')
    }else if(this.comment.level3 == '' || this.comment.level3 == null){
      alert('กรุณาเลือกระดับความพึงพอใจ')
    } else {
    console.log(this.comment.name);
    console.log(this.comment.phone);
    console.log(this.comment.level1);
    console.log(this.comment.level2);
    console.log(this.comment.level3);
    console.log(this.comment.post);
    this.httpClient.post('//localhost:8080/Comment/' 
      + this.comment.level1 + '/' 
      + this.comment.level2 + '/' 
      + this.comment.level3 + '/'
      + this.comment.name + '/'
      + this.comment.phone + '/' 
      + this.comment.post + '/'
      + this.province + '/'
      + this.gender,this.comment)
      
    .subscribe(
      data => {
                    alert("บันทึกสำเร็จ");
                    console.log('PUT Request is successful', data);

                },
                error => {
                          alert("Fail");
                          console.log('Fail', error);
                      }
            );
    
    }
  }
}
