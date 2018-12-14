import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SelectItem } from 'primeng/api';
import { Commit } from '../../../domain/commit'
import { Repo } from '../../../domain/repo'

declare var moment: any;

@Component({
  selector: 'app-commit',
  templateUrl: './commit.component.html',
  styleUrls: ['./commit.component.css']
})
export class CommitComponent implements OnInit {

  startdate: Date;
  enddate: Date;
  repos: Repo[];
  selectedRepo: Repo;
  authors: SelectItem[];
  selectedAuthor: string;
  commits: Commit[];

  constructor(private http: HttpClient) { }

  ngOnInit() {
    let today = new Date();
    this.startdate = new Date(today.getFullYear(), today.getMonth(), 1);
    this.enddate = new Date(today.getFullYear(), today.getMonth() + 1, 1);
    this.http.get<Repo[]>('/repo/find/all').subscribe(data => this.repos = data);
    this.http.get<string[]>('/commit/find/authors').subscribe(data => {
      this.authors = [];
      data.forEach(element => {
        this.authors.push({ label: element, value: element });
      });
    });
  }

  query(): void {
    let sdate = moment(this.startdate).format('YYYY-MM-DD');
    let edate = moment(this.enddate).format('YYYY-MM-DD');
    let repoId = this.selectedRepo == undefined ? "" : this.selectedRepo.id;
    let authorName = this.selectedAuthor == undefined ? "" : this.selectedAuthor;
    this.http.get<Commit[]>('/commit/find/startdate/' + sdate + '/enddate/' + edate + '?repoId=' + repoId + '&authorName=' + authorName).subscribe(data => this.commits = data);
  }
}
