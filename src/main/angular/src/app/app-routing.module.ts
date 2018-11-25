import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainComponent } from './component/main/main.component';
import { HomeComponent } from './component/main/home/home.component';
import { CommitComponent } from './component/main/commit/commit.component';
import { RepoComponent } from './component/main/repo/repo.component';

const routes: Routes = [
  { path: '', redirectTo: '/main/home', pathMatch: 'full' },
  { path: 'main', component: MainComponent, children: [
    { path: 'home', component: HomeComponent },
    { path: 'commit', component: CommitComponent },
    { path: 'repo', component: RepoComponent }
  ] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
