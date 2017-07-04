import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { LoginPage } from './login';
import { DictionaryModule } from '../../providers/dictionary-service/dictionary-module';


@NgModule({
  declarations: [
    LoginPage,
  ],
  imports: [
    DictionaryModule,
    IonicPageModule.forChild(LoginPage),
  ],
  exports: [
    LoginPage
  ]
})
export class LoginPageModule {}
