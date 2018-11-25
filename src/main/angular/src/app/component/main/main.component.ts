import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  items: MenuItem[];

  constructor() { }

  ngOnInit() {
    this.items = [
      { label: 'Home', routerLink: 'home' },
      { label: 'Commit', routerLink: 'commit' },
      { label: 'Repo', routerLink: 'repo' }
    ];
  }

}
