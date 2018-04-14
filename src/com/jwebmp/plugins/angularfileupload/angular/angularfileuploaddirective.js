/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

JW_APP_NAME.directive('ngFileModel', angularFileUploadDirective);

function angularFileUploadDirective() {
    return {
        scope: {
            ngFileModel: "="
        },
        link: function (scope, element, attributes) {
            element.bind("change", function (changeEvent) {
                var reader = new FileReader();
                reader.onload = function (loadEvent) {
                    scope.$apply(function () {
                        scope.ngFileModel = {
                            lastModified: changeEvent.target.files[0].lastModified,
                            lastModifiedDate: changeEvent.target.files[0].lastModifiedDate,
                            name: changeEvent.target.files[0].name,
                            size: changeEvent.target.files[0].size,
                            type: changeEvent.target.files[0].type,
                            data: loadEvent.target.result
                        };
                    });
                };
                reader.readAsDataURL(changeEvent.target.files[0]);
            });
        }
    }
}
