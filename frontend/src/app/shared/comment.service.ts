import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
providedIn: 'root'
})

export class CommentService {
httpOptions = {
headers: new HttpHeaders({
          'Content-Type':  'application/json'
        })
      };

      public API = '//localhost:8080';
      constructor(
        private http: HttpClient
      ) {
      }

      getLevel(): Observable<any> {
        return this.http.get(this.API + '/Level');
      }

      getComment(): Observable<any> {
        return this.http.get(this.API + '/Comment');
      }

      getProvince(): Observable<any> {
        return this.http.get(this.API + '/province');
      }

      getGender(): Observable<any> {
        return this.http.get(this.API + '/Gender');
      }

}

/*export class Level {
  levelId: number;
  levelname: string;
}*/

export class Comment {
  commentid: any;
  level1: any;
  level2: any;
  level3: any;
  name: any;
  phone: any;
  post: any;
}

