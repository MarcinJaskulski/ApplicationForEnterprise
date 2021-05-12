import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {

  student?: Student; // ? - może być pusty/ null-owy

  constructor(
    private route: ActivatedRoute,
    private studentService: StudentService,
    private location: Location
  ) {}
   

  ngOnInit() {
    this.getStudent();
  }

  public goBack(): void {
    this.location.back();
  }

  public save(): void {
    this
      .studentService
      .updateStudent(this.student!) // infomacja, że bierzący student w momencie wywołania na pewno będzie ustwiony
      .subscribe(() => this.goBack()); // jeśli coś się pojawi (a powrotna odp. jest zawsze) to zrób goBack()
  }

  private getStudent(): void {
    const pathId = this.route.snapshot.paramMap.get('id');
    if (pathId) {
      this
        .studentService
        .getStudent(+pathId) // +pathId -> konwersja string na int
        .subscribe(student => this.student = student);
    }
  }
}
