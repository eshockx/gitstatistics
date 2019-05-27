import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Repo } from '../../domain/repo';

@Component({
  selector: 'app-repo',
  templateUrl: './repo.component.html',
  styleUrls: ['./repo.component.css']
})
export class RepoComponent implements OnInit {

  repos: Repo[] = [];

  isLoading: boolean[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get<Repo[]>(environment.baseUrl + '/repo/find/all').subscribe(data => {
      this.repos = data;
      this.isLoading = new Array(this.repos.length);
    });
  }

  extractFromRepo(repo: Repo, index: number) {
    this.isLoading[index] = true;
    this.http.get(environment.baseUrl + '/commit/extract/repo/' + repo.id).subscribe(data => this.isLoading[index] = false);
  }
}
