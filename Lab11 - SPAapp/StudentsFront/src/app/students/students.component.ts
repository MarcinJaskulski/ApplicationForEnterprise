import { Component, OnInit } from '@angular/core';
import {Student} from '../student';
import {StudentService} from '../student.service';


@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {

  students!: Student []; // ! - oznacza, że pole będzie zainicjowane przed użyciem

  // Taki sposób deklaracji parametru konstruktora (z kwalifikatorem widzialności)
  // jednocześnie tworzy prywatną właściwość w klasie.
  constructor(private studentService: StudentService) { } 

  ngOnInit(): void {
    this.getStudents();
  }

  private getStudents(): void {
    this
      .studentService
      .getStudents()
      .subscribe(students => this.students = students); // czeka na jakąś odpoweidź i jeśli nadejdzie, to coś z nią robi
  }

  public create(index: number, firstName: string, lastName: string): void {
    this
      .studentService
      .createStudent(new Student( index, firstName, lastName)) // wysyłamy,
      .subscribe(student => { this.students.push(student); }); // a otrzymaną odpowiedź przy pomocy subskrybcji 
                                                               // wsadzamy do this.students
  }

  public delete(student: Student): void {
    this.students = this.students.filter(s => s.id !== student.id);
    this
      .studentService
      .deleteStudent(student)
      .subscribe();
  }
}
