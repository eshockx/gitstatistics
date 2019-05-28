import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Commit } from '../../domain/commit';
import { Repo } from '../../domain/repo';

declare var moment: any;

@Component({
  selector: 'app-commit',
  templateUrl: './commit.component.html',
  styleUrls: ['./commit.component.css']
})
export class CommitComponent implements OnInit {

  dateRange: Date[] = [new Date(), new Date()];
  repos: Repo[] = [];
  selectedRepo: string;
  authors: string[] = [];
  selectedAuthor: string;
  commits: Commit[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get<Repo[]>(environment.baseUrl + '/repo/find/all').subscribe(data => this.repos = data);
    this.http.get<string[]>(environment.baseUrl + '/commit/find/authors').subscribe(data => this.authors = data);
  }

  search() {
    let sdate = moment(this.dateRange[0]).format('YYYY-MM-DD');
    let edate = moment(this.dateRange[1]).format('YYYY-MM-DD');
    let repoId = this.selectedRepo == undefined ? "" : this.selectedRepo;
    let authorName = this.selectedAuthor == undefined ? "" : this.selectedAuthor;
    this.http.get<Commit[]>(environment.baseUrl + '/commit/find/startdate/' + sdate + '/enddate/' + edate + '?repoId=' + repoId + '&authorName=' + authorName).subscribe(data => this.commits = data);
  }
}
