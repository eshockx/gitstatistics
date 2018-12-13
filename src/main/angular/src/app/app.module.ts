import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { TabMenuModule } from 'primeng/tabmenu';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './component/main/main.component';
import { HomeComponent } from './component/main/home/home.component';
import { CommitComponent } from './component/main/commit/commit.component';
import { RepoComponent } from './component/main/repo/repo.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    HomeComponent,
    CommitComponent,
    RepoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ButtonModule,
    TableModule,
    TabMenuModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
