import { __decorate } from "tslib";
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { UserLayoutComponent } from './user-layout/user-layout.component';
import { AdminMenuComponent } from './admin-layout/admin-menu/admin-menu.component';
import { UserMenuComponent } from './user-layout/user-menu/user-menu.component';
import { HeaderComponent } from './header/header.component';
import { RouterModule } from '@angular/router';
//import { UserLayoutComponent } from './user-layout/user-layout.component';
//import { UserMenuComponent } from './user-layout/user-menu/user-menu.component';
/**
 * Modulo di layout. Viene caricato nel rputer outlet padre e poi
 * non viene più ricaricato. Quando clicchiamo su un link ricarichiamo solo l'outlet
 * che sta dentro AdminLayoutComponent
 *
 * @author Vittorio Valent
 *
 * @see AdminLayoutComponent
 */
var LayoutModule = /** @class */ (function () {
    function LayoutModule() {
    }
    LayoutModule = __decorate([
        NgModule({
            declarations: [AdminLayoutComponent, AdminMenuComponent, UserMenuComponent, HeaderComponent, UserLayoutComponent],
            imports: [
                CommonModule,
                RouterModule
            ]
        })
    ], LayoutModule);
    return LayoutModule;
}());
export { LayoutModule };
//# sourceMappingURL=layout.module.js.map