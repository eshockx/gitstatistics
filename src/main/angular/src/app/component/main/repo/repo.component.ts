import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Repo } from '../../../domain/repo'

@Component({
  selector: 'app-repo',
  templateUrl: './repo.component.html',
  styleUrls: ['./repo.component.css']
})
export class RepoComponent implements OnInit {

  repos: Repo[];
  extractDisabled: boolean;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get<Repo[]>('/repo/find/all').subscribe(data => this.repos = data);
  }

  extractFromRepo(repoId: String) {
    this.extractDisabled = true;
    this.http.get('/commit/extract/repo/' + repoId).subscribe(data => this.extractDisabled = false);
  }
}
