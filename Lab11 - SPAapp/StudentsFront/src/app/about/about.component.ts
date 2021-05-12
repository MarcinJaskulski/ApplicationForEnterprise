import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  public date!: Date;

  constructor() { }

  ngOnInit(): void {
    this.getCurrentDate();
  }

  private getCurrentDate(): void {
    this.date = new Date(Date.now());
  }
}
